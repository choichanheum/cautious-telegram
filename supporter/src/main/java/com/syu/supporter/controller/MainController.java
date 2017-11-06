package com.syu.supporter.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	private static final Logger logger = 
			LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping(value = "main.do")
	public String main(Model model) {
		logger.info("Welcome mainController home! "+new Date());
		model.addAttribute("hello", "hello i'm heum");
		return "home/home";
	}
	
	@RequestMapping(value = "board.do")
	public String board(Model model) {
		logger.info("board page gogo "+new Date());
		return "board/board";
	}
	
	
}

