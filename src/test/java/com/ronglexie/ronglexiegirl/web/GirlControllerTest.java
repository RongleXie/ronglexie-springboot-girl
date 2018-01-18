package com.ronglexie.ronglexiegirl.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.http.client.MockClientHttpRequest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

/**
 * controller测试类
 *
 * @author wxt.xqr
 * @version 2018-1-18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class GirlControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void findByAge() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/girl/girls/fingByAge/1"))
				.andExpect(MockMvcResultMatchers.status().isOk());
//						.andExpect(MockMvcResultMatchers.content().string("1"));
	}
}