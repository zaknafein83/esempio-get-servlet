<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>

<body>

<% List<String> elencoNomiCitt� = (List<String>)request.getAttribute("listaCitta"); %>
<table>
  <tr>
    <th>Nome Citt�</th>
  </tr>	
  <% for(String nomeCittaNellaLista : elencoNomiCitt�) { %>
  <tr>
    <td>
				<%=nomeCittaNellaLista%>
	</td>  
  </tr>
	<% } %>
</table>
<form action="scegliCountry">
  <input type="submit" value="Torna Indietro">

</form>
</body>
</html>