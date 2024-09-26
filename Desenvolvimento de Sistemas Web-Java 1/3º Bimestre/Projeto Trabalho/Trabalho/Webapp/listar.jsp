<%@page import="org.trabalho.Pessoa2"%>
<%@page import="org.trabalho.PessoaDao2"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="style.css" type="text/css">
<meta charset="UTF-8">
<title>Listar</title>
</head>
<body class="fundo1">
<div class="container mt-5">
	<h1 class="titulo">Cadastro de Vendedores</h1><br/><br/>
	
	<table class="table table-striped">
		<th>Id</th>
		<th>Nome</th>
		<th>Telefone</th>
		<th>Email</th>
		<th>Cidade</th>
		<th></th>
		<%
			PessoaDao2 dao = new PessoaDao2();
			for (Pessoa2 p : dao.listar()){
				out.print("<tr>");
				out.print("<td>" + p.getIdvendedor() + "</td>");
				out.print("<td>" + p.getNome() + "</td>");
				out.print("<td>" + p.getTelefone() + "</td>");
				out.print("<td>" + p.getEmail() + "</td>");
				out.print("<td>" + p.getCidade() + "</td>");
				out.print("<td>");
				out.print("<a class='link' href='formulario.jsp?id=" + p.getIdvendedor() + "'>Alterar</a>");
				out.print("<a class='link' href='excluir.jsp?id=" + p.getIdvendedor() + "'>Excluir</a>");
				out.print("</td>");
				
				out.print("</tr>");				
			}
		%>
	</table>
</div>
	<a class="tag" href="index.jsp">Início</a>
	<a class="tag" href="formulario.jsp?id=0">Novo</a>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>