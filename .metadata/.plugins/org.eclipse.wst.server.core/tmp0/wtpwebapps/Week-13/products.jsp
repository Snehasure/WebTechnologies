<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title>Products</title>
</head>
<body>
<h2>Books</h2>
<form action="<%= request.getContextPath() %>/add-to-cart" method="post"> Java Programming - ₹500
<input type="hidden" name="name" value="Java Programming">
<input type="hidden" name="price" value="500">
<button>Add</button>
</form>
<br>
<form action="<%= request.getContextPath() %>/add-to-cart" method="post"> Data Structures - ₹400
<input type="hidden" name="name" value="Data Structures">
<input type="hidden" name="price" value="400">
<button>Add</button>
</form>
<br><br>
<a href="<%= request.getContextPath() %>/cart">Go to Cart</a>
</body>
</html>
