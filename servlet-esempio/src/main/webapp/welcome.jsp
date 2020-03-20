<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
benvenuto nella nostra prima pagina JSP

<form action="habla">
  <label for="nomeParametro">Inserisci il CountryCode:</label>
  <input type="text" id="nomeParametro" name="nomeParametro"><br><br>
  <label for="limit">Inserisci quante città vuoi vedere:</label>
  <input type="text" id="limit" name="limit"><br><br>
  <input type="submit" value="Mostra">

</form>
</body>
</html>