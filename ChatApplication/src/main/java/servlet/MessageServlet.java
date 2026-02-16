package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.DBConnection;

@WebServlet("/sendMessage")

public class MessageServlet extends HttpServlet {
	
	 @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws IOException {

	        String user = (String) request.getSession().getAttribute("user");
	        String message = request.getParameter("message");

	        if (user == null || message == null || message.trim().isEmpty()) {
	            response.sendRedirect("login.jsp");
	            return;
	        }

	        try {
	            Connection con = DBConnection.getConnection();
	            PreparedStatement ps = con.prepareStatement(
	                "INSERT INTO messages(username, message) VALUES (?, ?)"
	            );
	            ps.setString(1, user);
	            ps.setString(2, message);
	            ps.executeUpdate();

	            response.sendRedirect("chat.jsp");

	        } catch (Exception e) {
	            e.printStackTrace();
	            response.getWriter().println("Message send failed");
	        }
	    }
}
