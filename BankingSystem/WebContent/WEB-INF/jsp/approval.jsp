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
    <li><a href=""></a></li>
    <li><a href=""></a></li>
    <li><a href=""></a></li>
    <li><a href="create">NEW ACCOUNT</a></li>
    <li><a href="login">LOGIN</a></li>
    
    <li><a href="about">ABOUT US</a></li>
    </ul>
</div>



<table style="width:897px; background:#FFFFFF; margin:0 auto;">
<tr >
	<td width="300" valign="top" style="border-right:#666666 1px dotted;">
    	<div id="services"><h1>Services</h1><br>
		     <p> Bank typically offer a variety of services to assist individuals in managing their finances, including:

			Checking accounts,
			Savings accounts,
			Debit & credit cards,
			Insurance,
			Wealth management
			Most banks offer financial services for business owners who need to differentiate professional and personal finances. Different types of business banking services include:

			Business loans
			Checking accounts
			Savings accounts
			Debit and credit cards
			</p>
			
       </div>
	</td>
    
    <td width="1200" valign="top">
    	<div id="welcome" style="border-right:#666666 1px dotted;"><h1>Thanks ${username} for Registeration</h1><br>
    		Your request is being processed.
    		
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
		int count=0;
		while(rs.next())
		{
			count++;
		}
	    query="select * from customer";
		stmt=con.createStatement();
		rs=stmt.executeQuery(query);
		while(rs.next())
		{
			count++;
		}
		count-=1;
		count+=100000;
		out.println("If approved your account no will be"+count);
           %>
           <%
	rs.close();
	stmt.close();
	con.close();
	}
	catch(Exception e){
		e.printStackTrace();
	}
	%>
        </div>      
    </td>
    
    <td width="299" valign="top">
    	<div id="welcome" style="border-right:#666666 1px dotted;"><h1>Welcome</h1><br>
    	    <center><img src="images/globe_10.gif" alt="business" width="196" height="106"></center><br>
		    <p>Each people plan their site layouts depending upon their business type. Here comes a free designer template which provides you with a selection of different kinds of webdesign   starting from business template, fashion template, media template, Science template, Arts template and much more.</p>
	    	
	    </div>      
    </td>
            	
    
</tr></table>
    
<div id="footer_top">
  <div id="footer_navigation">
  

  </div>
  
  <div id="footer_copyright" >
 
    	    <center><img  alt="business"  width="196" height="106"></center><br>
		    <p>Each people plan their site layouts depending upon their business type. Here comes a free designer template which provides you with a selection of different kinds of webdesign   starting from business template, fashion template, media template, Science template, Arts template and much more.</p>
	  
  Copyright © Your Company Name</div>
</div>

<script type="text/javascript">
document.onload = ctck();
</script>
</div>

</body>
</html>
