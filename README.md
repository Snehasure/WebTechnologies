## 📂 Repository Structure – Week-wise Experiments (As in GitHub)

- Weeks 1–6 → **WT1-6**
- Week 8 → **Week-8**
- Week 9 → **Week-9**
- Week 10 → **BookStore1**
- Week 11 → **Week-11**
- Week 12 → **ShoppingCartApp**
- Week 13 → **Week-13**



Installations
Eclipse Installation:

✅ Step 1: Go to Eclipse download page

Open this link in your browser:

👉 [https://www.eclipse.org/downloads/](https://www.eclipse.org/downloads/packages/release/2022-06/r/eclipse-ide-enterprise-java-and-web-developers)

📥 ✅ Step 2: Download Eclipse Installer

Click:

👉 Download x64

This downloads:

eclipse-installer.exe
⚙️ ✅ Step 3: Run the installer
Double-click eclipse-installer.exe
Wait for installer to open
💻 ✅ Step 4: Choose correct Eclipse version

You will see multiple options.

👉 Select:

Eclipse IDE for Enterprise Java and Web Developers

✔ This version includes:

JSP support
Servlet support
Web Tools Platform (WTP)
Required for Tomcat
📁 ✅ Step 5: Choose install location

Example:

C:\Users\surep\eclipse

Then click:

Install
⏳ Step 6: Accept license & wait
Accept terms
Wait 5–10 minutes
🚀 ✅ Step 7: Launch Eclipse

Click:

Launch
📂 ✅ Step 8: Select workspace

Eclipse will ask for workspace folder.

Use:

C:\Users\surep\eclipse-workspace

Click:

Launch
⚠️ IMPORTANT (Must do before Eclipse)
🔧 Install Java (JDK)

Check if Java exists:

java -version

If not installed:

👉 Download JDK (recommended JDK 17 or 21) from:
https://adoptium.net/

Install it before running Eclipse.

🎯 AFTER INSTALL (for your experiment)

Now you can follow your lab steps:

✔ Add Tomcat 9
✔ Configure server
✔ Run JSP/Servlet

🔧 (Optional but important)

If Tomcat v9.0 is not visible in Eclipse:

👉 Go to:

Help → Eclipse Marketplace

Search:

Web Tools Platform (WTP)

Install it


MYSQL installtion:
Download MySQL

Go to the official site: https://dev.mysql.com/downloads/installer/

Download MySQL Installer (Community Edition)
2. Run the Installer

7
Open the .msi file
Choose setup type:
Developer Default (recommended for beginners)

Includes:
MySQL Server
MySQL Workbench (GUI tool)
3. Install Required Dependencies

Installer may ask to install:

Visual C++ Redistributables
Click Execute → wait till complete

4. Configure MySQL Server
Choose:
Standalone MySQL Server
Configuration:
Port: 3306 (default)
Authentication: Use Strong Password Encryption

6. Set Root Password
Set a password for root user
⚠️ Don’t forget this — you’ll need it to log in
7. Finish Installation
Click Execute → Finish
8. Verify Installation
Open:
MySQL Workbench
OR
Command Prompt:
mysql -u root -p
Enter password → If it connects, you're done ✅
🎯 Example for your project
CREATE DATABASE bookstore;
USE bookstore;
⚠️ Common problems
❌ MySQL not connecting

👉 Check:

Server running
Correct password
❌ Port already used

👉 Change port to:

3307

Apache Tomcat Installation
✅ STEP 1: Download Apache Tomcat 10.1

Go to:

👉 https://tomcat.apache.org/

Navigate to:
👉 Tomcat 10 → Download

Download:

Core → Windows zip (or zip for all OS)
📁 ✅ STEP 2: Extract Tomcat
Right-click downloaded ZIP
Click Extract Here / Extract All

Example location:

C:\apache-tomcat-10.1
📂 Folder structure (important)
apache-tomcat-10.1/
├── bin        (startup/shutdown scripts)
├── conf       (server config)
├── webapps    (deploy apps)
├── lib        (libraries)
├── logs       (logs)

•	bin	→	Contains	startup	(startup.bat/startup.sh)	and	shutdown	scripts
(shutdown.bat/shutdown.sh)


💻 ✅ STEP 3: Open Eclipse

👉 Open Eclipse IDE for Enterprise Java and Web Developers

🖥️ ✅ STEP 4: Open Servers tab

If not visible:

Window → Show View → Servers
➕ STEP 5: Add Tomcat Server
In Servers tab → click:
No servers are available → Click this link
Select:
Apache → Tomcat v10.1 Server
Click Next
📁 STEP 6: Configure Tomcat path

Click:

Browse

Select:

C:\apache-tomcat-10.1

Click:

Finish
⚙️ ✅ STEP 7: Verify server configuration

Double-click server:

Check ports:

HTTP port → 8080
Shutdown → 8005

👉 If 8080 busy:
Change to:

8081
▶️ STEP 8: Start Tomcat

Right-click server → Click:

Start

Status should be:

Started, Synchronized
🌐 STEP 9: Test in browser

Open:
To confirm that Tomcat is running, open a web browser and enter:
   http://localhost:8080/


👉 You should see:
✔ Apache Tomcat welcome page

🎉 DONE!

Your Tomcat 10.1 is successfully configured

CRUDServlet

│
├── Java Resources
│   │
│   └── src/main/java
│       │
│       └── com.servlet
│           │
│           └── Employee.java
│
├── Libraries
│
├── build
│
└── src
    │
    └── main
        │
        ├── java
        │
        └── webapp
            │
            ├── META-INF
            │
            ├── WEB-INF
            │   │
            │   ├── lib
            │   │   │
            │   │   ├── jakarta.servlet.jsp.jstl-2.0.0.jar
            │   │   ├── jakarta.servlet.jsp.jstl-api-2.0.0.jar
            │   │   └── mysql-connector-j-9.1.0.jar
            │   │
            │   └── web.xml
            │
            └── index.html

index.html

<!DOCTYPE html>

<html>

<head>
    <title>Employee CRUD Operations</title>
</head>

<body>

<center>

<h1>Employee CRUD Operations Using Servlet</h1>

<!-- CREATE OPERATION -->

<form method="post"
action="http://localhost:8080/CRUDServlet/Employee">

<h2>Create Employee</h2>

<table border="1" cellpadding="10">

<tr>
<td>Username</td>
<td>
<input type="text" name="username">
</td>
</tr>

<tr>
<td>Salary</td>
<td>
<input type="text" name="salary">
</td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" value="Create Employee">
</td>
</tr>

</table>

</form>

<br><br>

<!-- READ OPERATION -->

<form method="get"
action="http://localhost:8080/CRUDServlet/Employee">

<h2>Read Employee</h2>

<table border="1" cellpadding="10">

<tr>
<td>Username</td>

<td>
<input type="text" name="username">
</td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" value="Read Employee">
</td>
</tr>

</table>

</form>

<br><br>

<!-- UPDATE OPERATION -->

<form method="post"
action="http://localhost:8080/CRUDServlet/Employee">

<input type="hidden"
name="_method"
value="put">

<h2>Update Employee</h2>

<table border="1" cellpadding="10">

<tr>
<td>Username</td>

<td>
<input type="text" name="username">
</td>
</tr>

<tr>
<td>New Salary</td>

<td>
<input type="text" name="salary">
</td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" value="Update Employee">
</td>
</tr>

</table>

</form>

<br><br>

<!-- DELETE OPERATION -->

<form method="post"
action="http://localhost:8080/CRUDServlet/Employee">

<input type="hidden"
name="_method"
value="delete">

<h2>Delete Employee</h2>

<table border="1" cellpadding="10">

<tr>
<td>Username</td>

<td>
<input type="text" name="username">
</td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" value="Delete Employee">
</td>
</tr>

</table>

</form>

</center>

</body>

</html>

Employee.java

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
@WebServlet("/Employee")

public class Employee extends HttpServlet {

    // READ OPERATION

    public void doGet(HttpServletRequest req,
                      HttpServletResponse res)
                      throws IOException {

        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        String username = req.getParameter("username");

        try {

            // LOAD DRIVER

            Class.forName("com.mysql.cj.jdbc.Driver");

            // CREATE CONNECTION

            Connection con =
            DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/userdb",
            "root",
            "Sneh@sure2005");

            // SQL QUERY

            String query =
            "SELECT salary FROM employee WHERE name=?";

            PreparedStatement pst =
            con.prepareStatement(query);

            pst.setString(1, username);

            ResultSet rs = pst.executeQuery();

            out.println("<html><body>");

            if(rs.next()) {

                out.println("<h2>Employee Found</h2>");

                out.println("<h3>Username : "
                + username + "</h3>");

                out.println("<h3>Salary : "
                + rs.getString(1) + "</h3>");

            }

            else {

                out.println("<h2>Employee Not Found</h2>");
            }

            out.println("</body></html>");

            con.close();

        }

        catch(Exception e) {

            out.println(e);
        }
    }

    // CREATE OPERATION

    public void doPost(HttpServletRequest req,
                       HttpServletResponse res)
                       throws IOException {

        String method = req.getParameter("_method");

        // UPDATE CALL

        if("put".equalsIgnoreCase(method)) {

            doPut(req,res);
            return;
        }

        // DELETE CALL

        if("delete".equalsIgnoreCase(method)) {

            doDelete(req,res);
            return;
        }

        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        String username =
        req.getParameter("username");

        String salary =
        req.getParameter("salary");

        try {

            // LOAD DRIVER

            Class.forName("com.mysql.cj.jdbc.Driver");

            // CONNECTION

            Connection con =
            DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/userdb",
            "root",
            "Sneh@sure2005");

            // INSERT QUERY

            String query =
            "INSERT INTO employee VALUES(?,?)";

            PreparedStatement pst =
            con.prepareStatement(query);

            pst.setString(1, username);

            pst.setString(2, salary);

            int rows = pst.executeUpdate();

            out.println("<html><body>");

            if(rows > 0) {

                out.println("<h2>Employee Created Successfully</h2>");
            }

            else {

                out.println("<h2>Employee Creation Failed</h2>");
            }

            out.println("</body></html>");

            con.close();

        }

        catch(Exception e) {

            out.println(e);
        }
    }

    // UPDATE OPERATION

    public void doPut(HttpServletRequest req,
                      HttpServletResponse res)
                      throws IOException {

        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        String username =
        req.getParameter("username");

        String salary =
        req.getParameter("salary");

        try {

            // LOAD DRIVER

            Class.forName("com.mysql.cj.jdbc.Driver");

            // CONNECTION

            Connection con =
            DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/userdb",
            "root",
            "Sneh@sure2005");

            // UPDATE QUERY

            String query =
            "UPDATE employee SET salary=? WHERE name=?";

            PreparedStatement pst =
            con.prepareStatement(query);

            pst.setString(1, salary);

            pst.setString(2, username);

            int rows = pst.executeUpdate();

            out.println("<html><body>");

            if(rows > 0) {

                out.println("<h2>Employee Updated Successfully</h2>");
            }

            else {

                out.println("<h2>Employee Update Failed</h2>");
            }

            out.println("</body></html>");

            con.close();

        }

        catch(Exception e) {

            out.println(e);
        }
    }

    // DELETE OPERATION

    public void doDelete(HttpServletRequest req,
                         HttpServletResponse res)
                         throws IOException {

        res.setContentType("text/html");

        PrintWriter out = res.getWriter();

        String username =
        req.getParameter("username");

        try {

            // LOAD DRIVER

            Class.forName("com.mysql.cj.jdbc.Driver");

            // CONNECTION

            Connection con =
            DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/userdb",
            "root",
            "Sneh@sure2005");

            // DELETE QUERY

            String query =
            "DELETE FROM employee WHERE name=?";

            PreparedStatement pst =
            con.prepareStatement(query);

            pst.setString(1, username);

            int rows = pst.executeUpdate();

            out.println("<html><body>");

            if(rows > 0) {

                out.println("<h2>Employee Deleted Successfully</h2>");
            }

            else {

                out.println("<h2>Employee Delete Failed</h2>");
            }

            out.println("</body></html>");

            con.close();

        }

        catch(Exception e) {

            out.println(e);
        }
    }
}

web.xml
<?xml version="1.0" encoding="UTF-8"?>

<web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee
         https://jakarta.ee/xml/ns/jakartaee/web-app_5_0.xsd"
         version="5.0">

</web-app>

mysql code
CREATE DATABASE userdb;
USE userdb;
CREATE TABLE employee(
    name VARCHAR(50),
    salary VARCHAR(50)
);
INSERT INTO employee VALUES('Rahul','50000');
INSERT INTO employee VALUES('Sneha','60000');
select * from employee;


JSPCRUD operations

CRUDJSP
│
├── Java Resources
│   └── src/main/java
         |__com
            |__servlet
               |__Employee.java
│
├── src
│   └── main
│       │
│       ├── java
│       │
│       └── webapp
│           │
│           ├── META-INF
│           │
│           ├── WEB-INF
│           │   │
│           │   ├── lib
│           │   │   ├── mysql-connector-j-9.x.x.jar
│           │   │   ├── jakarta.servlet.jsp.jstl-api.jar
│           │   │   └── jakarta.servlet.jsp.jstl.jar
│           │   │
│           │   └── web.xml
│           │
│           ├── index.jsp
│           ├── create.jsp
│           ├── read.jsp
│           ├── update.jsp
│           └── delete.jsp
│
├── build
│
└── Libraries


Employee.java

package com.servlet;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class Employee {

    private String name;
    private String salary;

    public Employee() {
    }

    public Employee(String name, String salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}

web.xml

<web-app>
    <servlet>
        <servlet-name>Employee</servlet-name>
        <servlet-class>Employee</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>Employee</servlet-name>
        <url-pattern>/Employee/*</url-pattern>
    </servlet-mapping>

    <servlet-mapping>
        <servlet-name>Employee</servlet-name>
        <url-pattern>/Employee</url-pattern>
    </servlet-mapping>

    <welcome-file-list>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>
</web-app>

create.jsp
<%@ page import="java.sql.*" %>

<%
    String username = request.getParameter("username");
    String salary = request.getParameter("salary");

    try {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con =
        DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/userdb",
        "root",
        "Sneh@sure2005");

        String checkQuery =
        "SELECT * FROM employee WHERE name = ?";

        PreparedStatement checkPst =
        con.prepareStatement(checkQuery);

        checkPst.setString(1, username);

        ResultSet checkRs = checkPst.executeQuery();

        if (checkRs.next()) {

            out.println("Employee already exists");

        } else {

            String insertQuery =
            "INSERT INTO employee (name, salary) VALUES (?, ?)";

            PreparedStatement pst =
            con.prepareStatement(insertQuery);

            pst.setString(1, username);
            pst.setString(2, salary);

            int rows = pst.executeUpdate();

            if (rows > 0) {
                out.println("Employee created successfully");
            } else {
                out.println("Error creating employee");
            }
        }

        con.close();

    } catch (Exception e) {
        e.printStackTrace(new java.io.PrintWriter(out));
    }
%>

delete.jsp
<%@ page import="java.sql.*" %>

<%
    String username = request.getParameter("username");

    try {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con =
        DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/userdb",
        "root",
        "Sneh@sure2005");

        String deleteQuery =
        "DELETE FROM employee WHERE name = ?";

        PreparedStatement pst =
        con.prepareStatement(deleteQuery);

        pst.setString(1, username);

        int rows = pst.executeUpdate();

        if (rows > 0) {

            out.println("Employee deleted successfully");

        } else {

            out.println("Error deleting employee");

        }

        con.close();

    } catch (Exception e) {

        e.printStackTrace(new java.io.PrintWriter(out));

    }
%>

index.jsp
<!DOCTYPE html>
<html>
<head>
    <title>Employee Management</title>
</head>
<body>

<center>

    <h3>Employee Management Page</h3>

    <!-- CREATE -->

    <form name="create" method="post" action="create.jsp">

        <h4>Create Employee</h4>

        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username"></td>
            </tr>

            <tr>
                <td>Salary:</td>
                <td><input type="text" name="salary"></td>
            </tr>
        </table>

        <input type="submit" value="Create">

    </form>

    <br/>

    <!-- READ -->

    <form name="read" method="get" action="read.jsp">

        <h4>Read Employee</h4>

        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username"></td>
            </tr>
        </table>

        <input type="submit" value="Read">

    </form>

    <br/>

    <!-- UPDATE -->

    <form name="update" method="post" action="update.jsp"
          onsubmit="return confirm('Are you sure you want to update?')">

        <h4>Update Employee</h4>

        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username"></td>
            </tr>

            <tr>
                <td>Salary:</td>
                <td><input type="text" name="salary"></td>
            </tr>
        </table>

        <input type="submit" value="Update">

    </form>

    <br/>

    <!-- DELETE -->

    <form name="delete" method="post" action="delete.jsp"
          onsubmit="return confirm('Are you sure you want to delete?')">

        <h4>Delete Employee</h4>

        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username"></td>
            </tr>
        </table>

        <input type="submit" value="Delete">

    </form>

</center>

</body>
</html>

read.jsp
<%@ page import="java.sql.*" %>

<%
    String username = request.getParameter("username");

    try {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con =
        DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/userdb",
        "root",
        "Sneh@sure2005");

        String query =
        "SELECT * FROM employee WHERE name=?";

        PreparedStatement pst =
        con.prepareStatement(query);

        pst.setString(1, username);

        ResultSet rs = pst.executeQuery();

        if(rs.next()) {

            out.println("<h3>Employee Found</h3>");
            out.println("Name: " + rs.getString("name"));
            out.println("<br>");
            out.println("Salary: " + rs.getString("salary"));

        } else {

            out.println("Employee not found");

        }

        con.close();

    } catch(Exception e) {

        e.printStackTrace(new java.io.PrintWriter(out));

    }
%>

update.jsp

<%@ page import="java.sql.*" %>

<%
    String username = request.getParameter("username");
    String salary = request.getParameter("salary");

    try {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con =
        DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/userdb",
        "root",
        "Sneh@sure2005");

        String updateQuery =
        "UPDATE employee SET salary = ? WHERE name = ?";

        PreparedStatement pst =
        con.prepareStatement(updateQuery);

        pst.setString(1, salary);
        pst.setString(2, username);

        int rows = pst.executeUpdate();

        if (rows > 0) {

            out.println("Employee updated successfully");

        } else {

            out.println("Error updating employee");

        }

        con.close();

    } catch (Exception e) {

        e.printStackTrace(new java.io.PrintWriter(out));

    }
%>

mysql code

CREATE DATABASE userdb;
USE userdb;
CREATE TABLE employee(
    name VARCHAR(50),
    salary VARCHAR(50)
);
INSERT INTO employee VALUES('Rahul','50000');
INSERT INTO employee VALUES('Sneha','60000');
select * from employee;

