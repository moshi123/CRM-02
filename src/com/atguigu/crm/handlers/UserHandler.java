package com.atguigu.crm.handlers;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atguigu.crm.entitys.User;
import com.atguigu.crm.services.UserService;

@Controller
public class UserHandler {
	@Autowired
     private UserService userService;
	@Autowired
	private ResourceBundleMessageSource messageSource;
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam(value="username")  String username,@RequestParam(value="password") String password
			,RedirectAttributes attributes, Locale locale, HttpSession session
			){
	
		User user = userService.login(username, password);
		if(user !=null){
			session.setAttribute("user",user);
			return "success";	
		}
		attributes.addFlashAttribute("message",messageSource.getMessage("error.user.login", null,locale));
	
		return  "redirect:/index";
	}
	
	
}
