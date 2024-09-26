<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	double homens = Double.parseDouble(request.getParameter("homens"));
	double mulheres = Double.parseDouble(request.getParameter("mulheres"));
	double criancas = Double.parseDouble(request.getParameter("criancas"));
	double carne = (homens * 0.300) + (mulheres * 0.270) + (criancas * 0.250);
	double cerveja = (homens * 2) + (mulheres * 1.5);
	double refrigerante = (homens * 0.3) + (mulheres * 0.6) + (criancas * 1);
	%>
	<div>
	Quantidade que deverá ser comprada:
	Carne <%= carne %>kg, Cerveja <%= cerveja %>litros, <%= refrigerante %>litros;
	</div>
	

</body>
</html>