package com.bookstore; import jakarta.servlet.*; import jakarta.servlet.http.*; import java.io.IOException; import java.util.*;
public class BookServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// Sample book list
List<String> books = Arrays.asList( "Java Programming",
"Python Basics", "Web Development", "Database Systems"
);
request.setAttribute("books", books);
RequestDispatcher rd = request.getRequestDispatcher("books.jsp"); rd.forward(request, response);
}
}
