<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
     
 	<%
	String s[] = request.getParameterValues("select");
	if (s != null && s.length != 0) {
		out.println("You have selected the option is: ");
		for (int i = 0; i < s.length; i++) {
			out.println(s[i]);
		}
	}
	%>
</body>
</html>