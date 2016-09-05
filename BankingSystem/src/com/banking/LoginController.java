package com.banking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping("/login")
	public ModelAndView login(){
		return new ModelAndView("login","command",new Login());
	}
	@RequestMapping("/verify")
	public String verify(@ModelAttribute("SpringWeb")Login log,ModelMap model){
		model.addAttribute("accountno",log.getAccountno());
		model.addAttribute("username",log.getUsername());
		model.addAttribute("password",log.getPassword());
		Connection con=GetCon.getCon();
		try{
			Statement st=con.createStatement();
			String s="select * from login where accountno='"+log.getAccountno()+"'and username='"+log.getUsername()+"'and password='"+log.getPassword()+"' "	;	
			ResultSet rs=st.executeQuery(s);
			if(rs.next())
				return "result";
				
		}
		catch(Exception e){
			System.out.println(e);
		}
		return "error";
	}
	@RequestMapping("/admin")
	public ModelAndView admin(){
		return new ModelAndView("admin","command",new Admin());
	}
	@RequestMapping("/admincontrol")
	public String a(@ModelAttribute("SpringWeb")Admin log,ModelMap model){
		model.addAttribute("username",log.getUsername());
		model.addAttribute("password",log.getPassword());
		
		try{
			if(log.getUsername().equals("javed")&&log.getPassword().equals("ahmed"))
				return "admincontrol";
			else
				return "error";
				
		}
		catch(Exception e){
			System.out.println(e);
		}
		return "error";
	}
}
