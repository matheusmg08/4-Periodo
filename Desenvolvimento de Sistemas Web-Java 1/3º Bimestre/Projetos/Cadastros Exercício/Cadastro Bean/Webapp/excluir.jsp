<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="p" class="org.libertas.Pessoa" scope="page"/>
	<jsp:useBean id="pdao" class="org.libertas.PessoaDao" scope="page"/>
	<jsp:setProperty property="*" name="p"/>
	${ pdao.excluir(p)}
	
	Registro excluído com sucesso!
	<br/>
	<a href="index.jsp">Ok</a>
	

</body>
</html>