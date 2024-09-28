<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css" type="text/css">
<meta charset="ISO-8859-1">
<title>Excluir</title>
</head>
<body class="fundo1">
	<jsp:useBean id="p" class="org.trabalho.Pessoa2" scope="page"/>
	<jsp:useBean id="pdao" class="org.trabalho.PessoaDao2" scope="page"/>
	<jsp:setProperty property="*" name="p"/>
	${ pdao.excluir(p)}
	
	<a class="links" href="index.jsp">Início</a>
	<p class="mensagem"> Registro excluído com sucesso</p><br/>
	

</body>
</html>