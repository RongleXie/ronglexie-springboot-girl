package com.ronglexie.ronglexiegirl.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ronglexie
 * @version 2018-2-1
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
