package com.ronglexie.ronglexiegirl.redis;

import com.ronglexie.ronglexiegirl.entity.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * redis测试类
 *
 * @author ronglexie
 * @version 2018-2-5
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String,Girl> redisTemplate;

	@Test
	public void testRedis() {
		// 保存字符串
		stringRedisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

		Girl girl1 = new Girl("A",19);
		redisTemplate.opsForValue().set(girl1.getCupSize(),girl1);
		Girl girl2 = new Girl("B",20);
		redisTemplate.opsForValue().set(girl2.getCupSize(),girl2);
		Girl girl3 = new Girl("C",21);
		redisTemplate.opsForValue().set(girl3.getCupSize(),girl3);

		Assert.assertEquals(19,redisTemplate.opsForValue().get(girl1.getCupSize()).getAge().longValue());
		Assert.assertEquals(20,redisTemplate.opsForValue().get(girl2.getCupSize()).getAge().longValue());
		Assert.assertEquals(21,redisTemplate.opsForValue().get(girl3.getCupSize()).getAge().longValue());
	}
}
