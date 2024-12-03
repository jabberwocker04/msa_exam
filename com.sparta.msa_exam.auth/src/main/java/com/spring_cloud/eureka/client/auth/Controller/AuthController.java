package com.spring_cloud.eureka.client.auth.Controller;

import com.spring_cloud.eureka.client.auth.Dto.SignUpDto;
import com.spring_cloud.eureka.client.auth.Entity.User;
import com.spring_cloud.eureka.client.auth.Repository.UserRepository;
import com.spring_cloud.eureka.client.auth.Service.AuthService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Value("${server.port}") //
    String ServerPort;

    @PostMapping("/auth/sign-up")
    public ResponseEntity<String> signup(@RequestBody SignUpDto signUpDto) {

        String encodedPassword = passwordEncoder.encode(signUpDto.getPassword());
        User user = new User(signUpDto.getUsername(), encodedPassword);
        userRepository.save(user);

        return ResponseEntity.ok()
                .headers(DefaultHeaders()) // Server-Port 헤더 추가
                .body("회원가입이 완료되었습니다.");
    }

    @PostMapping("/auth/sign-in")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody SignUpDto loginDto){
    String token = authService.login(loginDto.getUsername(), loginDto.getPassword());
        if (token.equals("Invalid username or password.")) {
            return ResponseEntity.badRequest().body(token);
        }
        return ResponseEntity.ok()
            .headers(DefaultHeaders())
            .body("로그인 성공");
    }



    /**
     * JWT 액세스 토큰을 포함하는 응답 객체입니다.
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class AuthResponse {
        private String access_token;

    }

    public HttpHeaders DefaultHeaders() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Server-Port", ServerPort);
        return responseHeaders;
    }

}