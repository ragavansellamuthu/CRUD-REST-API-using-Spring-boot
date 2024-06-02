package com.techietact.mycognitiv.candidate.configuration;

import java.time.Duration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
@EnableCaching
public class CacheConfig {

	@Bean
	@Profile("redis")
	CacheManager redisCacheManager(RedisConnectionFactory connectionFactory) {
		RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
				.entryTtl(Duration.ofHours(2));
		return RedisCacheManager.builder(connectionFactory).cacheDefaults(cacheConfiguration).build();
	}

	@Bean
	@Profile("!redis")
	CacheManager noOpCacheManager() {
		return new ConcurrentMapCacheManager(); 
	}
}
