package com.atguigu.crm.handlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/chance")
@Controller
public class OkHandler {

	@RequestMapping("/ok")
	public String ok() {
		System.out.println("asdasdjasdkj klas");
		return "chance/ok";
	}
}
