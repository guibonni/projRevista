<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Revistas</title>
</head>
<body>
	<form action="RevistaCtrl" method="post">
		<table>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="nome" required=true size=50></td>
			</tr>
			<tr>
				<td>Ano:</td>
				<td><input type="number" name="ano" required=true min=1600 max=2018></td>
			</tr>
			<tr>
				<td>Mês:</td>
				<td>
					<select name="mes" required=true>
						<option value="Janeiro">Janeiro</option>
						<option value="Fevereiro">Fevereiro</option>
						<option value="Março">Março</option>
						<option value="Abril">Abril</option>
						<option value="Maio">Maio</option>
						<option value="Junho">Junho</option>
						<option value="Julho">Julho</option>
						<option value="Agosto">Agosto</option>
						<option value="Setembro">Setembro</option>
						<option value="Outubro">Outubro</option>
						<option value="Novembro">Novembro</option>
						<option value="Dezembro">Dezembro</option>
	 				</select>
				</td>
			</tr>
			<tr>
				<td>Quantidade de Páginas:</td>
				<td><input type="number" name="qtdPags" required=true min=20 max=9999></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="Cadastrar">
	</form>
	
	<% if (request.getAttribute("msg") != null) { %>
		<br><br>
		<b><%=request.getAttribute("msg")%></b>
	<% } %>
</body>
</html>