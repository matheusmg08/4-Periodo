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
	double dolar = Double.parseDouble(request.getParameter("dolar"));
	String descricao = request.getParameter("descricao");
	double quantidade = Double.parseDouble(request.getParameter("quantidade"));
	double reais = 5.48 * dolar;
	double total = reais * quantidade;
	out.print("O preço do produto em dólar é: US$ " + dolar + ", a descrição é: " + descricao + ", o preço unitário em reais é R$: " + reais + ", e o valor total em reais é: R$" + total);
	
	%>
	

</body>
</html>