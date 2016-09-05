package com.banking;
import java.sql.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class RegisterController {
	@RequestMapping("/create")
	public ModelAndView newAccount(){
		return new ModelAndView("create","command",new Register());
	}
	@RequestMapping("/CreateAccount")
	public String verify(@ModelAttribute("SpringWeb")Register reg,ModelMap model){
		model.addAttribute("username",reg.getUsername());
		model.addAttribute("password",reg.getPassword());
		model.addAttribute("repassword",reg.getRepassword());
		model.addAttribute("amount",reg.getAmount());
		model.addAttribute("gender",reg.getGender());
		model.addAttribute("password",reg.getAddress());
		model.addAttribute("age",reg.getAge());
		model.addAttribute("phone",reg.getPhone());
		model.addAttribute("email",reg.getEmail());
		Connection con=GetCon.getCon();
		try{
			Statement st=con.createStatement();
			int i=100000;
			ResultSet resultSet = st.executeQuery("SELECT COUNT(*) FROM customer");

		    // Get the number of rows from the result set
		    resultSet.next();
		    int rowcount = resultSet.getInt(1);
		    i+=rowcount;
		    resultSet = st.executeQuery("SELECT COUNT(*) FROM signup");

		    // Get the number of rows from the result set
		    resultSet.next();
		    rowcount = resultSet.getInt(1);
		    i+=rowcount;
			String sql="INSERT into signup values('"+i+"','"+reg.getUsername()+"','"+reg.getPassword()
					+"','"+reg.getAmount()+"','"+reg.getGender()+"','"+reg.getAddress()+"','"+
					reg.getAge()+"','"+reg.getPhone()+"','"+reg.getEmail()+"')";
			st.executeUpdate(sql);		
		}
		catch(Exception e){
			System.out.println(e);
		}
		return "approval";
	}
	@RequestMapping("/request")
	public String registerRequest(){
		return "request";
	}
}
