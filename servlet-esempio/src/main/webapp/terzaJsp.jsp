<%@page import="it.dstech.formazione.servlet.models.Macchina"%>
<%@page import="it.dstech.formazione.servlet.models.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<% Object parametro = request.getAttribute("elemento");
	if(parametro instanceof Persona){
		Persona p = (Persona) parametro;
		%>
		<h2>Ciao e benvenuto <%=p.getNome() %></h2>
		<%
	}
	else {
		Macchina m = (Macchina) parametro;
		%>
		<h2>Ciao e benvenuto <%=m.getModello() %> tu hai <%=m.getCilindrata() %> di cilindrata  </h2>
		<%
		
	}
%>
</body>
</html>