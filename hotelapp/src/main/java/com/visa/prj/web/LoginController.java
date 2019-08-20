package com.visa.prj.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")		//place model data-user in session scope
public class LoginController {

    @RequestMapping("Login.do")
    public String doLogin(@RequestParam("email") String email, @RequestParam("pwd") String pwd, Model m) {
        //validation
    	m.addAttribute("user", email);
        return "index.jsp";   //default is server side redirection
    }
     
    @RequestMapping("logout.do") 	//normal way - just to demonstrate
    public String doLogout(HttpServletRequest req) {
        HttpSession ses = req.getSession(false);
        ses.removeAttribute("user");
        ses.invalidate();
        return "redirect:login.html";   //client side redirection
    }
     
}
