package com.jameer.hackernewsapis.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;


@Component
public class RedisCacheFlush implements ApplicationRunner {

    private final RedisConnectionFactory redisConnectionFactory;

    public RedisCacheFlush(RedisConnectionFactory redisConnectionFactory) {
        this.redisConnectionFactory = redisConnectionFactory;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        redisConnectionFactory.getConnection().serverCommands().flushAll();
    }
}
