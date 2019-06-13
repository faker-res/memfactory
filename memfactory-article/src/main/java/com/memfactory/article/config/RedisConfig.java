/**
 * 
 */
package com.memfactory.article.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.StringUtils;

import com.memfactory.article.properties.RedisProperties;

import redis.clients.jedis.JedisPoolConfig;

/**
 * @author zhairp createDate: 2018-11-15
 */
@Configuration
public class RedisConfig {

	@Autowired
	private RedisProperties redisProperties;

	private RedisConnectionFactory generateReleaseConnectionFactory() {
		JedisPoolConfig poolConfig = generatePoolConfig();
		JedisConnectionFactory factory = new JedisConnectionFactory(poolConfig);
		factory.setHostName(redisProperties.getHost());
		factory.setPort(redisProperties.getPort());
		factory.setTimeout(10000);
		if (!StringUtils.isEmpty(redisProperties.getPassword())) {
			factory.setPassword(redisProperties.getPassword());
		}
		factory.setUsePool(true);
		factory.setConvertPipelineAndTxResults(true);
		factory.afterPropertiesSet();
		return factory;
	}

	private JedisPoolConfig generatePoolConfig() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMinIdle(redisProperties.getMinIdle());
		poolConfig.setMaxTotal(redisProperties.getMaxTotal());
		poolConfig.setMaxWaitMillis(5000);
		poolConfig.setTestOnBorrow(true);
		return poolConfig;
	}

	@Bean(name = "redisConnectionFactory")
	RedisConnectionFactory factory() {
		return generateReleaseConnectionFactory();
	}

	@Bean(name = "redisTemplate")
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
		final RedisTemplate<String, Object> template = new RedisTemplate<>();
		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
		template.setEnableTransactionSupport(false);
		template.setKeySerializer(stringRedisSerializer);
		template.setHashKeySerializer(stringRedisSerializer);
		template.setValueSerializer(jdkSerializationRedisSerializer);
		template.setDefaultSerializer(jdkSerializationRedisSerializer);
		template.setConnectionFactory(factory);
		return template;
	}

	@Bean(name = "stringRedisTemplate")
	public RedisTemplate<String, String> stringRedisTemplate(RedisConnectionFactory factory) {
		final RedisTemplate<String, String> template = new RedisTemplate<>();
		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		template.setEnableTransactionSupport(true);
		template.setKeySerializer(stringRedisSerializer);
		template.setHashKeySerializer(stringRedisSerializer);
		template.setValueSerializer(stringRedisSerializer);
		template.setDefaultSerializer(stringRedisSerializer);
		template.setConnectionFactory(factory);
		return template;
	}

}
