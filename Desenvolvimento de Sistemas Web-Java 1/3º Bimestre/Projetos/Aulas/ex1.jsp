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
	String time1 = request.getParameter("time1");
	int gol1 = Integer.parseInt(request.getParameter("gol1"));
	String time2 = request.getParameter("time2");
	int gol2 = Integer.parseInt(request.getParameter("gol2"));
	
	String campeao;
	if ((gol1) > (gol2)){
		campeao = time1;
		out.print("Campeão foi o time:" +time1);
	}
	else if ((gol2) > (gol1)){
		campeao = time2;
		out.print("Campeão foi o time:" +time2);
	}
	else{
		campeao = "empate";
		out.print("O resultado do jogo entre " + time1 + " e " + time2 + " foi empate");
	}
	%>
	
	


</body>
</html>