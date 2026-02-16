<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    HttpSession session1 = request.getSession(false);
    String user = null;

    if (session1 == null || session1.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
        return;
    } else {
        user = session1.getAttribute("username").toString();
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Chat Page</title>
</head>
<body>

<form action="logout" method="get">
    <button type="submit">Logout</button>
</form>

<h2>Welcome, <%= user %></h2>

<textarea rows="10" cols="50" readonly>
Chat messages will appear here
</textarea>

<br><br>

<input type="text" placeholder="Type your message">
<button>Send</button>

</body>
</html>