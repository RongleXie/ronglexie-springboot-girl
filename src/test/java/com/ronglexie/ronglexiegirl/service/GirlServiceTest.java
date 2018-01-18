package com.ronglexie.ronglexiegirl.service;

import com.ronglexie.ronglexiegirl.entity.Girl;
import com.ronglexie.ronglexiegirl.service.GirlService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * service测试类
 *
 * @author ronglexie
 * @version 2018-1-18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class GirlServiceTest {

	@Autowired
	private GirlService girlService;

	@Test
	@Rollback(true)
	public void saveGirl() {
		girlService.save(new Girl("A", 20));
	}
}
