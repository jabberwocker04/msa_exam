package com.spring_cloud.eureka.client.product;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;

@Configuration
@EnableCaching
public class CacheConfig {
    @Bean
    public RedisCacheManager cacheManager(
            RedisConnectionFactory redisConnectionFactory
    ) {
        RedisCacheConfiguration config = RedisCacheConfiguration
                .defaultCacheConfig()// 기본 설정 사용
                .entryTtl(Duration.ofSeconds(60)) // 기본 캐시 유지 시간(Time to Live)으로, 요구사항대로 60초 설정
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.java())
                ) // 캐시에 저장할 값을 어떻게 직렬화 / 역직렬화 할 것인지
                ;

        return RedisCacheManager
                .builder(redisConnectionFactory)
                .cacheDefaults(config)
                .build();
    }
}
