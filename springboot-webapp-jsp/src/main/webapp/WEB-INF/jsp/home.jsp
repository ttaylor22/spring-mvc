<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel = "stylesheet" type="text/css" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />

<title>Insert </title>
</head>
<body>
	<div class="container">
		<header>
			<h1>Spring MVC</h1>
			<h3>(Using JSP, JPA, & Spring Boot 2.2.1)</h3>
		</header>
		<div class="starter-template">
			<h2>Users List</h2>
			<table class="table table-striped table-hover table-condensed table-bordered">
				<tr>
					<th>Id</th>
					<th>Name</th>
				</tr>
				<c:forEach var="user" items="${users}">
					<tr>
						<form action="/users" method="post">
							<td><input type="text" name="id" value="${user.id}" readonly/></td>
							<td><input type="text" name="name" value="${user.name}"/></td>
							<td><button type="submit" name="type" value="edit">Edit</button></td>
						</form>
						<form action="/users" method="post">
							<td><button type="submit" name="type" value="remove">Remove</button></td>
							<input type="hidden" name="id" value="${user.id}">
							<input type="hidden" name="name" value=0/>
						</form>
					</tr>
				</c:forEach>
					<tr>	
						<form action="/users" method="post">
							<td><button type="submit" name="type" value="save">Save</button></td>
							<td><input type="text" name="name" value=""/></td>
							<input type="hidden" name="id" value=0>
						</form>
					</tr>
			</table>
		
			
		</div>
	</div>
	<script type="text/javascript"
  src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>