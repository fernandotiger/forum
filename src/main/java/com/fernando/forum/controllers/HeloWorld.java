package com.fernando.forum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeloWorld {

	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return "Hello world";
	}
}
