package com.ronglexie.ronglexiegirl.redis;

import com.ronglexie.ronglexiegirl.entity.Girl;
import com.ronglexie.ronglexiegirl.serializer.RedisObjectSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis配置类
 *
 * @author ronglexie
 * @version 2018-2-5
 */
@Configuration
public class RedisConfig {

	@Bean
	public RedisTemplate<String, Girl> redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, Girl> template = new RedisTemplate<String, Girl>();
		template.setConnectionFactory(factory);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new RedisObjectSerializer());
		return template;
	}
}
