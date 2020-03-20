<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%List<String> elencoNomiCittà = (List<String>)request.getAttribute("listaCitta"); %>
<ul>
	<% for(String n : elencoNomiCittà) { %>
	<li><%=n%></li>
	<% } %>
</ul>

<form action="welcome.jsp">
  <input type="submit" value="Torna Indietro">

</form>
</body>
</html>