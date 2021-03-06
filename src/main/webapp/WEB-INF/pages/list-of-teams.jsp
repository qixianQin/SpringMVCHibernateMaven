<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of teams</title>
</head>
<body>

<h1>List of teams</h1>
<p> Here you can see the list of the teams, edit them, remove or update</p>

<table border="1px" cellpadding="0" cellspacing="0">
<thead>
<tr>
	<th width="10%">id</th> <th width="15%">name</th><th width="10%">rating</th><th width="10%">action</th>
</tr>
</thead>
<tbody>
	<c:forEach var="team" items="${teams}">
		<tr>
			<td>${team.id}</td>
			<td>${team.name}</td>
			<td>${team.rating}</td>
			<td>
				<a href="${pageContext.request.contextPath}/team/edit/${team.id}.html">Edit</a>
				<a href="${pageContext.request.contextPath}/team/delete/${team.id}.html">Delete</a>
			</td>
		</tr>
	</c:forEach>
</tbody>
</table>


<p> <a href="${pageContext.request.contextPath}/index.html">Home page</a></p>
</body>
</html>