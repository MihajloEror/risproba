<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prikaz glumaca i uloga</title>
</head>
<body>
	<c:if test="${empty glumis}">
		<h4>Nema glumaca za odabranu predstavu.</h4>
	</c:if>
	<c:if test="${!empty glumis}">
		<h4>Uloge za predstavu:</h4>
		<table border="1">
			<tr>
				<th>Ime</th>
				<th>Prezime</th>
				<th>Uloga</th>
			</tr>
			<c:forEach items="${glumis}" var="g">
				<tr>
					<td>${g.glumac.ime}</td>
					<td>${g.glumac.prezime}</td>
					<td>${g.uloga.naziv}</td>
				</tr>
			</c:forEach>
		</table><br/>
		Ukupan broj uloga u predstavi: ${brojUloga}
	</c:if><br><br>
	<form action="/Pozoriste/predstave/goBack" method="post">
		<button type="submit">Nazad</button>
	</form>
</body>
</html>