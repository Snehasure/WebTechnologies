package com.bookstore; import jakarta.servlet.*; import jakarta.servlet.http.*; import java.io.IOException;
public class AuthFilter implements Filter {
public void init(FilterConfig config) throws ServletException {}
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
HttpServletRequest request = (HttpServletRequest) req; HttpServletResponse response = (HttpServletResponse) res; HttpSession session = request.getSession(false);
String loginURI = request.getContextPath() + "/login.jsp"; String servletPath = request.getServletPath();
boolean loggedIn = session != null && session.getAttribute("username") != null; boolean loginRequest = request.getRequestURI().equals(loginURI);
boolean loginServlet = servletPath.equals("/LoginServlet"); if (loggedIn || loginRequest || loginServlet) {
chain.doFilter(request, response);
} else {
response.sendRedirect(loginURI);
}
}
public void destroy() {}
}
