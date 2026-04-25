<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>BookStore Login</title>
<style>
.container { width: 300px; margin: 100px auto; }
.error { color: red; }
input { margin: 5px; padding: 5px; width: 200px; } button { padding: 5px 10px; }
</style>
</head>
<body>
<div class="container">
<h2>BookStore Login</h2>
<form action="LoginServlet" method="post">
<input type="text" name="username" placeholder="Username" required><br>
<input type="password" name="password" placeholder="Password" required><br>
<button type="submit">Login</button>
</form>
<% if (request.getAttribute("errorMessage") != null) { %>
<p class="error"><%= request.getAttribute("errorMessage") %></p>
<% } %>
</div>
</body>
</html>
