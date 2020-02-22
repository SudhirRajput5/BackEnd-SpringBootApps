package com.sudhir.Internationalization;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping("/s")
	public String hello() {
		return "welcome";
	}
}
