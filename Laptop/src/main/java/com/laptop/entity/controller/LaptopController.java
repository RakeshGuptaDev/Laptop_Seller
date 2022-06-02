package com.laptop.entity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LaptopController {
	
	@RequestMapping("/")
	public String show() {
		return "index.jsp";
	}
}
