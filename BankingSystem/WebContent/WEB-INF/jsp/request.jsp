<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<SCRIPT LANGUAGE="JavaScript">
function dil(form)
{
   for(var i=0; i<form.elements.length; i++)
   {
		if(form.elements[i].value == "")
		{
		   alert("Fill out all Fields")
		   document.F1.accountno.focus()
		   return false
		}
   }

   if(isNaN(document.F1.accountno.value))
   {
       alert("Accountno must  be  number & can't be null")
	   document.F1.accountno.value=""
	   document.F1.accountno.focus()
	   return false
   }
   if(!isNaN(document.F1.username.value))
   {
       alert("User Name  must  be  char's & can't be null")
	   document.F1.username.value=""
	   document.F1.username.focus()
	   return false
   }

   if(!isNaN(document.F1.password.value))
   {
       alert("Password  must  be  char's & can't be null")
	   document.F1.password.value=""
	   document.F1.password.focus()
	   return false
   }
   
   return true   
}
</SCRIPT>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Global Banking ..</title>
<spring:url value="/images/style.css" var="style" />
<link href="${style}" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function ctck()
{
var sds = document.getElementById("dum");

}
</script>

</head>

<body>

<div id="top_links">
  

<div id="header">
	<h1>TCS - BANK<span class="style1"></span></h1>
    <h2>ExtraOrdinary Service</h2>	
    <A href=""><IMG SRC="images/home1.gif"></IMG></A>
</div>

<div id="navigation">
    <ul>
   
    
    <li><a href="closeac">CLOSE A/C</a></li>
    
    <li><a href="about">ABOUT US</a></li>
    <li><a href="request">Requests</a></li>
    </ul>
</div>

<table style="width:897px; background:#FFFFFF; margin:0 auto;">
	<tr>
	<td>accountno</td>
	<td>username</td>
	<td>password</td>
	<td>amount</td>
	<td>gender</td>
	<td>address</td>
	<td>age</td>
	<td>phone</td>
	<td>email</td>
	<td>select</td>
	</tr>
	<%
	try{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/banking";
		String username="Banking";
		String password="Banking";
		String query="select * from signup";
		Connection con=DriverManager.getConnection(url,username,password);
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		while(rs.next())
		{
		
		%>
           <tr><td><%=rs.getInt("accountno") %></td>
           <td><%=rs.getString("username") %></td>	
           <td><%=rs.getString("password") %></td>
           <td><%=rs.getInt("amount") %></td>
           <td><%=rs.getString("gender") %></td>
           <td><%=rs.getString("address") %></td>
           <td><%=rs.getInt("age") %></td>
           <td><%=rs.getInt("phone") %></td>
           <td><%=rs.getString("email") %></td>
           <td><input type="checkbox"></td></tr>
           <%
		}
           %>
         
</table>
<a href="approve"><input type="submit" value="Approve" style="height:50px;width:150px"/></a>
<a href="reject"><input type="submit" value="Reject" style="height:50px;width:150px"/></a>
	<%
	rs.close();
	stmt.close();
	con.close();
	}
	catch(Exception e){
		e.printStackTrace();
	}
	%>

    
<div id="footer_top">
  <div id="footer_navigation">
  

  </div>
  
  <div id="footer_copyright" >
 
    	    <center><img  alt="business"  width="196" height="106"></center><br>
		    <p>Each people plan their site layouts depending upon their business type. Here comes a free designer template which provides you with a selection of different kinds of webdesign   starting from business template, fashion template, media template, Science template, Arts template and much more.</p>
	  
  Copyright © TCS BANK</div>
</div>

<script type="text/javascript">
document.onload = ctck();
</script>
</div>

</body>
</html>
