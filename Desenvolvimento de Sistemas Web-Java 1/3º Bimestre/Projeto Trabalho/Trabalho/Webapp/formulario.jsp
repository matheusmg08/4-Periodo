<%@page import="org.trabalho.PessoaDao2"%>
<%@page import="org.trabalho.Pessoa2"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="style.css" type="text/css">
<meta charset="ISO-8859-1">
<title>Formulário</title>
</head>
<body class="fundo1">

	<%
	int idvendedor = Integer.parseInt(request.getParameter("id"));
	Pessoa2 p = new Pessoa2 ();
	PessoaDao2 pdao = new PessoaDao2();
	if (idvendedor > 0){
		p = pdao.consultar(idvendedor);
	} else{
		//limpa os dados para novo
		p.setNome("");
		p.setTelefone("");
		p.setEmail("");
		p.setCidade("");
		
	}
	
	%>
	
	<h1 class="titulo">Informe os dados dos vendedores</h1>

	<div class="mb-3">
	<form action="gravar.jsp" method="post">
		<input type="hidden" name="idvendedor" value="<%= p.getIdvendedor() %>"/>
		Nome:
		<input type="text" class="form-control" id="inputDefault" placeholder="Digite o nome do vendedor" name="nome" value="<%=p.getNome() %>" required/>
		<br/>
		Telefone:
		<input type="text" class="form-control" id="inputDefault" placeholder="Digite o telefone do vendedor" name="telefone" value="<%=p.getTelefone() %>" required/>
		<br/>
		Email:
		<input type="text" class="form-control" id="inputDefault" placeholder="Digite o e-mail do vendedor" name="email" value="<%=p.getEmail() %>" required/>
		<br/>
		Cidade:
		<input type="text" class="form-control" id="inputDefault" placeholder="Digite a cidade do vendedor" name="cidade" value="<%=p.getCidade() %>" required/>
		<br/>
		<input class="button" type="submit" value="salvar"/>
		<br/><br/>
	</form>
	</div>
	<a class="tag" href="index.jsp">Início</a>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>