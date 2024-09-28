<%@page import="org.trabalho.Pessoa2"%>
<%@page import="org.trabalho.PessoaDao2"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css">
<meta charset="UTF-8">
<title>Gravar</title>
</head>
<body class="fundo1">

	<%
		PessoaDao2 dao = new PessoaDao2();
		Pessoa2 p = new Pessoa2();
		p.setIdvendedor(Integer.parseInt(request.getParameter("idvendedor")));
		p.setNome(request.getParameter("nome"));
		p.setTelefone(request.getParameter("telefone"));
		p.setEmail(request.getParameter("email"));
		p.setCidade(request.getParameter("cidade"));
		//salvar vendedor
		if (p.getIdvendedor()>0){
			dao.alterar(p);
		} else{
			dao.inserir(p);
		}
	%>
	<h1 class="msg">Vendedor salvo com sucesso !</h1>
	<a class="links" href="index.jsp">Ok</a>

</body>
</html>