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

<% List<String> countryCode = (List<String>) request.getAttribute("country"); %>

<form action="habla">
  <label for="nomeParametro">Inserisci il CountryCode:</label>
	<select name = "nomeParametro">
	
	<% for (String cc : countryCode){%>
	  <option value="<%=cc %>"><%=cc %></option>
	  
	  <% } %>
	</select>
	<br>
  <label for="limit">Inserisci quante città vuoi vedere:</label>
  <input type="number" id="limit" min = "1"  max = "15" name="limit"><br><br>
  <input type="submit" value="Mostra">

</form>



</body>
</html>