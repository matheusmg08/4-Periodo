<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css">
<meta charset="ISO-8859-1">
<title>Gravar</title>
</head>
<body class="fundo1">
	<jsp:useBean id="p" scope="page" class="org.trabalho.Pessoa2"/>
	<jsp:useBean id="pdao" scope="page" class="org.trabalho.PessoaDao2"/>
	<jsp:setProperty property="*" name="p"/>
	<% pdao.salvar(p); %>
	
	<h1 class="msg">Vendedor salvo com sucesso !</h1>
	<a class="links" href="index.jsp">Ok</a>
	

</body>
</html>