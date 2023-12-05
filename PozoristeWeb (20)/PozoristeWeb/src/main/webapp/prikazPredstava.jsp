<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prikaz predstava</title>
</head>
<body>
	<form action="/Pozoriste/predstave/getPredstave" method="get">
		Žanr: <select name="idZanra">
			<c:forEach items="${zanrovi}" var="z">
				<option value="${z.idZanr}">${z.naziv}</option>
			</c:forEach>
		</select> 
		<input type="submit" value="Prikaži" />
	</form><br>
	<c:if test="${!empty odabraniZanr}">
Predstave za odabrani zanr: ${odabraniZanr.naziv}

		<table border="1">
			<tr>
				<th>Naziv</th>
				<th>Trajanje</th>
				<th>Opis</th>
				<th>Reziser</th>
				<th>Uloge</th>
			</tr>
			<c:forEach items="${predstave }" var="p">
				<tr>
					<td>${p.naziv }</td>
					<td>${p.trajanje }</td>
					<td>${p.opis }</td>
					<td>${p.reziser.ime} ${p.reziser.prezime}</td>
					<td><a href="/Pozoriste/predstave/getGlumci?idP=${p.idPredstava}">Uloge</a></td>
				</tr>
			</c:forEach>

		</table>
	</c:if>
</body>
</html>