package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/contact")
	public String contactUs() {
		return "contact";
	}
}
