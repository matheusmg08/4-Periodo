<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	<jsp:useBean id="pdao" scope="page" class="org.trabalho.PessoaDao2" />
	
	<div class="container mt-5">
	<h1 class="titulo">Cadastro de Vendedores</h1><br/><br/>
	
	<table class="table table-striped">
		<th>Nome</th>
		<th>Telefone</th>
		<th>E-mail</th>
		<th>Cidade</th>
		<th></th>
	
	<c:forEach var="p" items="${pdao.listar()}">
		<tr>
			<td>${p.nome}</td>
			<td>${p.telefone}</td>
			<td>${p.email}</td>
			<td>${p.cidade}</td>
			<td><a class="link" href="formulario.jsp?idvendedor=${p.idvendedor}">Alterar</a>
			<a class="link" href="excluir.jsp?idvendedor=${p.idvendedor}">Excluir</a>
			</td>
		</tr>
	
	</c:forEach>
	</table>
</div>
	<a class="tag" href="index.jsp">Início</a>
	<a class="tag" href="formulario.jsp?id=0">Novo</a>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>