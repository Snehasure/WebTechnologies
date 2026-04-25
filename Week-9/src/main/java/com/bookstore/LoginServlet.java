package com.bookstore; import jakarta.servlet.*; import jakarta.servlet.http.*; import java.io.IOException;
public class LoginServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String username = request.getParameter("username"); String password = request.getParameter("password");
if (DatabaseConnection.validateUser(username, password)) { HttpSession session = request.getSession(); session.setAttribute("username", username); response.sendRedirect("welcome.jsp");
} else {
request.setAttribute("errorMessage", "Invalid username or password"); RequestDispatcher rd = request.getRequestDispatcher("login.jsp"); rd.forward(request, response);
}
}
}
