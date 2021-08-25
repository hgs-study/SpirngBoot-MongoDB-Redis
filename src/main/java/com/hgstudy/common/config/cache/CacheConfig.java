package com.hgstudy.common.config.cache;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
@RequiredArgsConstructor
public class CacheConfig {

    private final RedisConnectionFactory connectionFactory;

    //Spring에서는 캐싱을 할 때 로컬 캐시에 저장하지 않고 redis에 저장하게 됩니다.
    @Bean
    public CacheManager redisCacheManager() {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                                                                                 .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                                                                                 .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()))
                                                                                 .entryTtl(Duration.ofSeconds(30)); //TTL 적용도 가능하다.

        RedisCacheManager redisCacheManager = RedisCacheManager.RedisCacheManagerBuilder
                                                               .fromConnectionFactory(connectionFactory)
                                                               .cacheDefaults(redisCacheConfiguration)
                                                               .build();
        return redisCacheManager;
    }
}
