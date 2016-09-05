package com.banking;
import java.sql.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class AdminController {
	@RequestMapping("/approve")
	public String approve(){
		Connection con=GetCon.getCon();
		try{
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from signup");
			if(rs.next())
			{
			String sql="insert into login values('"+rs.getInt(1)+"','"+rs.getString(2)+"','"+rs.getString(3)+"')";
			st.executeUpdate(sql);
			
			rs.close();
			}
		    rs=st.executeQuery("select * from signup");
		    
			if(rs.next())
			{
			int acc=rs.getInt(1);
		    String sql="insert into customer values('"+rs.getInt(1)+"','"+rs.getString(2)+"','"+rs.getString(3)
					+"','"+rs.getInt(4)+"','"+rs.getString(5)+"','"+rs.getString(6)+"','"+
					rs.getString(7)+"','"+rs.getString(8)+"','"+rs.getString(9)+"')";
		  
			st.executeUpdate(sql);
			sql="delete from signup where accountno='"+acc+"'";
			st.executeUpdate(sql);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		return "request";
	}
	@RequestMapping("/reject")
	public String reject(){
		Connection con=GetCon.getCon();
		try{
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from signup");
			if(rs.next()){
			
			int acc=rs.getInt(1);
			String sql="delete from signup where accountno='"+acc+"'";
			st.executeUpdate(sql);
			}
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		return "request";
	}
}
