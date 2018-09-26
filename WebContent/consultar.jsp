<%@page import="java.util.List"%>
<%@page import="br.com.projRevista.model.Revista"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consulta</title>
</head>
<body>
	<form method="post" action="ConsultaServlet">
		<table>
			<tr>
				<td>Nome: </td>
				<td><input type="text" name="filtro"></td>
			</tr>
			<tr>
				<td>Ano: </td>
				<td><input type="number" name="ano" min=1600></td>
			</tr>
		</table>
		<input type="submit" value="Consultar">
	</form>
	
	<% if (request.getAttribute("msg") != null) { %>
		<br><br>
		<b><%=request.getAttribute("msg")%></b>
	<% } %>
	
	<% if (request.getAttribute("rows") != null) { %>
	
	<table border="1">
		<tr>
			<th>Nome</th>
			<th>Ano</th>
			<th>Mês</th>
			<th>Páginas</th>
		</tr>
		
		<% List<Revista> rows = (List) request.getAttribute("rows"); %>
		<% try { %>
		<% for (Revista revista: rows) { %>
			<tr>
				<td><%=revista.getNome()%></td>
				<td><%=revista.getAno()%></td>
				<td><%=revista.getMes()%></td>
				<td><%=revista.getQtdPaginas()%></td>
			</tr>
		<% } %>
		<% } catch (NullPointerException e) { %>
		<% } %>
		
	</table>
	<% } %>
	<br>
	<form action="home.html"><input type="submit" value="Voltar" width=100></form>
</body>
</html>