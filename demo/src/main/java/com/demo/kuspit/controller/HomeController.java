package com.demo.kuspit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.kuspit.service.UsersService;


public class HomeController {

	  @Autowired
	    UsersService usersService;


	    @RequestMapping("/")
	    public String index() {
	        return "home";
	    }
}
