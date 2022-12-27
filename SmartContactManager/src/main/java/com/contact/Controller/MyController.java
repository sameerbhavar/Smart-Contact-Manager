package com.contact.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/about")
	public String about()
	{
		return "about";
	}
	
	@RequestMapping("/demo")
	public String demo()
	{
		return "demo";
	}
	
}
