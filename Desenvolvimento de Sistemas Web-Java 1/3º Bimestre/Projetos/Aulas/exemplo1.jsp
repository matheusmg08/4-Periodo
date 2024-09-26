<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%@ include file="topo.jsp" %>

	<h1> exemplo 1</h1>
	<%!
	//declaração
		public double media(double a, double b){
		return (a+b)/2.0;
	}
	%>
	

	<%
	int a = 1;
	int b = 2;
	int c = a+b;
	%>
	<div style='font-size:140px'>
	 <%= c %>
	 <br/>
	 <%= media(a,b) %>
	</div>
	
</body>
</html>