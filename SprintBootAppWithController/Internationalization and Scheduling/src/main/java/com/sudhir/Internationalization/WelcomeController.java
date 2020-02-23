package com.sudhir.Internationalization;

//this class is for internationalization

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping("/s")
	public String hello() {
		return "welcome";
	}
}
