<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="style.css" type="text/css">
<meta charset="UTF-8">
<title>Formulário</title>
</head>
<body class="fundo1">

	<jsp:useBean id="p" class="org.trabalho.Pessoa2" scope="page"/>
	<jsp:useBean id="pdao" class="org.trabalho.PessoaDao2" scope="page"/>
	<jsp:setProperty property="*" name="p"/>
	${p = pdao.consultar(p.idvendedor)}
	
	
	<h1 class="titulo">Informe os dados dos vendedores</h1>
	<div class="mb-3">
	<form action="gravar.jsp" method="post">
		<input type="hidden" name="idvendedor" value="${p.idvendedor}"/>
		Nome:
		<input type="text" class="form-control" id="inputDefault" placeholder="Digite o nome do vendedor" name="nome" value="${p.nome}" required/>
		<br/>
		Telefone:
		<input type="text" class="form-control" id="inputDefault" placeholder="Digite o telefone do vendedor" name="telefone" value="${p.telefone}" required/>
		<br/>
		E-mail:
		<input type="text" class="form-control" id="inputDefault" placeholder="Digite o e-mail do vendedor" name="email" value="${p.email}" required>
		<br/>
		Cidade:
		<input type="text" class="form-control" id="inputDefault" placeholder="Digite a cidade do vendedor" name="cidade" value="${p.cidade}" required/>
		<br/>
		<input class="button" type="submit" value="salvar"/>	
	</form>
	</div>
	<a class="tag" href="index.jsp">Início</a>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>