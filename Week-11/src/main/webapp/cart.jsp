<%@ page import="java.util.*" %>

<h2>Your Cart</h2>

<%
Map<Long, Integer> cart = (Map<Long, Integer>) session.getAttribute("cart");

if (cart == null || cart.isEmpty()) {
%>
    <p>Cart is empty</p>
<%
} else {
%>

<table border="1">
<tr>
    <th>Book ID</th>
    <th>Quantity</th>
</tr>

<%
for (Map.Entry<Long, Integer> entry : cart.entrySet()) {
%>
<tr>
    <td><%= entry.getKey() %></td>
    <td><%= entry.getValue() %></td>
</tr>
<%
}
%>

</table>

<%
}
%>

<a href="BookManagementServlet">Back to Books</a>