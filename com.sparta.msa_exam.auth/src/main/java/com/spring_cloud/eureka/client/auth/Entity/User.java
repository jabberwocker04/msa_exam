package com.spring_cloud.eureka.client.auth.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    private String id;

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }
}
