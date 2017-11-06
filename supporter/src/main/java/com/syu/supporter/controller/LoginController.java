package com.syu.supporter.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syu.supporter.login.LoginInfo;
import com.syu.supporter.login.LoginService;

@Controller
public class LoginController {
	private static final Logger logger = 
			LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "login.do")
	public String main(Model model) {
		logger.info("Welcome loginController home! "+new Date());
		model.addAttribute("hello", "hello i'm heum");
		return "login/login";
	}
	
	@RequestMapping(value = "loginAfter.do")
	public String loginCheck(Model model, LoginInfo loginInfo, HttpServletRequest request) {
		logger.info("Welcome LoginController loginAf! "+ new Date());
         
         
        if((loginInfo.getId() != null && !loginInfo.getId().equals("")
                && loginInfo.getPw() != null && !loginInfo.getPw().equals(""))){
             
       boolean check = loginService.loginCheck(loginInfo);
            if(check == true){
            	logger.info("Welcome LoginController loginAf!---- "+ check);
            	
                request.getSession().setAttribute("login", 0);
                
                request.getSession().setAttribute("id", loginInfo.getId());
                return "forward:main.do";
            }
            if(check == false){
            	 request.getSession().invalidate();
            	logger.info("Welcome LoginController loginAf!---- "+ check);
            	return "redirect:login.do";
            }   
        }
        logger.info("확인용");
        return "forward:main.do";
    }
	
	@RequestMapping(value = "logout.do")
	public String logout(Model model, HttpServletRequest request) {
		logger.info("Welcome LoginController loginout! "+ new Date());
		request.getSession().invalidate();
		return "login/login";
	}
	
	
}