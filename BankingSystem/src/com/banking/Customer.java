package com.banking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class Customer {
	
	@RequestMapping("/balance")
	public ModelAndView balance(){
		return new ModelAndView("balance","command",new Login1());
	}
	@RequestMapping("/balance1")
	public String balance(@ModelAttribute("SpringWeb")Login1 log,ModelMap model){
		//model.addAttribute("accountno",log.getAccountno());
		Connection con=GetCon.getCon();
		try{
			Statement st=con.createStatement();
			String s="select * from customer where accountno='"+log.getAccountno()+"'"	;	
			ResultSet rs=st.executeQuery(s);
			if(rs.next()){
				int bal=rs.getInt("amount");
				System.out.println(bal);
				model.addAttribute("balance",bal);
			}	
		}
		catch(Exception e){
			System.out.println(e);
		}
		return "balance1";
	}
	
	@RequestMapping("/deposit")
	public ModelAndView deposit(){
		return new ModelAndView("deposit","command",new Login1());
	}
	@RequestMapping("/deposit1")
	public String deposit(@ModelAttribute("SpringWeb")Login1 log,ModelMap model){
		//model.addAttribute("accountno",log.getAccountno());
		Connection con=GetCon.getCon();
		try{
			Statement st=con.createStatement();
			String s="select * from customer where accountno='"+log.getAccountno()+"'"	;	
			ResultSet rs=st.executeQuery(s);
			if(rs.next()){
				int bal=rs.getInt("amount");
				int bal1=log.getAmount();
				bal+=bal1;
				s="update customer set amount='"+bal+"'where accountno='"+log.getAccountno()+"'";
				st.executeUpdate(s);
				String s1=new Date().toString();
				s="insert into transaction values('"+log.getAccountno()+"','deposit','"+log.getAmount()+"','"+s1+"')";
				st.executeUpdate(s);
			}	
		}
		catch(Exception e){
			System.out.println(e);
		}
		return "success";
	}
	
	@RequestMapping("/withdraw")
	public ModelAndView withdraw(){
		return new ModelAndView("withdraw","command",new Login1());
	}
	@RequestMapping("/withdraw1")
	public String withdraw(@ModelAttribute("SpringWeb")Login1 log,ModelMap model){
		//model.addAttribute("accountno",log.getAccountno());
		Connection con=GetCon.getCon();
		try{
			Statement st=con.createStatement();
			String s="select * from customer where accountno='"+log.getAccountno()+"'"	;	
			ResultSet rs=st.executeQuery(s);
			if(rs.next()){
				int bal=rs.getInt("amount");
				int bal1=log.getAmount();
				bal-=bal1;
				if(bal>=1000){
				s="update customer set amount='"+bal+"'where accountno='"+log.getAccountno()+"'";
				st.executeUpdate(s);
				String s1=new Date().toString();
				s="insert into transaction values('"+log.getAccountno()+"','withdraw','"+log.getAmount()+"','"+s1+"')";
				st.executeUpdate(s);
				}
				else 
					return "unsuccess";
			}	
		}
		catch(Exception e){
			System.out.println(e);
		}
		return "success";
	}
	
	@RequestMapping("/transfer")
	public ModelAndView transfer(){
		return new ModelAndView("transfer","command",new Login1());
	}
	@RequestMapping("/transfer1")
	public String transfer(@ModelAttribute("SpringWeb")Login1 log,ModelMap model){
		//model.addAttribute("accountno",log.getAccountno());
		Connection con=GetCon.getCon();
		try{
			Statement st=con.createStatement();
			String s="select * from customer where accountno='"+log.getAccountno()+"'"	;	
			ResultSet rs=st.executeQuery(s);
			if(rs.next()){
				int bal=rs.getInt("amount");
				int bal1=log.getAmount();
				if(bal-bal1>=1000){
				int nbal=bal-bal1;
				s="update customer set amount='"+nbal+"'where accountno='"+log.getAccountno()+"'";
				st.executeUpdate(s);
				String s1=new Date().toString();
				s="insert into transaction values('"+log.getAccountno()+"','transfer','"+log.getAmount()+"','"+s1+"')";
				st.executeUpdate(s);
			    s="select * from customer where accountno='"+log.getAccountno1()+"'"	;
			    rs.close();
			    rs=st.executeQuery(s);
			    rs.next();
			    bal=rs.getInt("amount");
			    nbal=bal+bal1;
				s="update customer set amount='"+nbal+"'where accountno='"+log.getAccountno1()+"'";
				st.executeUpdate(s);
				}
				else 
					return "unsuccess";
			}	
		}
		catch(Exception e){
			return "unsuccess";
		}
		return "success";
	}
	
	@RequestMapping("/closeac")
	public ModelAndView close(){
		return new ModelAndView("close","command",new Login1());
	}
	@RequestMapping("/closeac1")
	public String close(@ModelAttribute("SpringWeb")Login1 log,ModelMap model){
		//model.addAttribute("accountno",log.getAccountno());
		Connection con=GetCon.getCon();
		try{
			Statement st=con.createStatement();
			String s="delete from customer where accountno='"+log.getAccountno()+"'";
			st.executeUpdate(s);
			s="delete from login where accountno='"+log.getAccountno()+"'";
			st.executeUpdate(s);
			s="delete from transaction where accountno='"+log.getAccountno()+"'";
			st.executeUpdate(s);
		}
		catch(Exception e){
			return "unsuccess";
		}
		return "success";
	}
	@RequestMapping("/transaction")
	public ModelAndView transaction(){
		return new ModelAndView("transaction","command",new Login1());
	}
	@RequestMapping("/transaction1")
	public String transaction(@ModelAttribute("SpringWeb")Login1 log,ModelMap model){
		model.addAttribute("accountno",log.getAccountno());
		return "transaction1";
	}
}
