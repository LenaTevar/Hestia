package com.hth.hestia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorsControllers {

	@GetMapping("/error")
	public String errorNotFound () {
		return "Error";
	}
	
}
