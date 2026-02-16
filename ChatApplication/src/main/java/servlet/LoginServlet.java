package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.DBConnection;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {
	
	 @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws IOException {

	        String username = request.getParameter("username");

	        try {
	            Connection con = DBConnection.getConnection();

	            PreparedStatement ps = con.prepareStatement(
	                "INSERT IGNORE INTO users(username) VALUES (?)"
	            );
	            ps.setString(1, username);
	            ps.executeUpdate();

	            request.getSession().setAttribute("user", username);
	            response.sendRedirect("chat.jsp");

	        } catch (Exception e) {
	            e.printStackTrace();
	            response.getWriter().println("Login failed");
	        }
	    }
}
