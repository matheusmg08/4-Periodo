<%@page import="org.trabalho.PessoaDao2"%>
<%@page import="org.trabalho.Pessoa2"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css">
<meta charset="UTF-8">
<title>Excluir</title>
</head>
<body class="fundo1">
	<%
	//declare um objeto Pessoa2
	Pessoa2 p = new Pessoa2();
	
	//receba o parametro id e atribua no objeto pessoa o valor do idvendedor
	p.setIdvendedor(Integer.parseInt(request.getParameter("id")));
	
	//declare o PessoaDao2
	PessoaDao2 pdao = new PessoaDao2();
	
	//execute o método excluir
	pdao.excluir(p);
	
	//adicione um link pra voltar para página lista.jsp
	%>
	<a class="links" href="listar.jsp">Listar</a>
	<p class="mensagem"> Registro excluído com sucesso</p><br/>
	

</body>
</html>