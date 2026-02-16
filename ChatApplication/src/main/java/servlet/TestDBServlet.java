package servlet;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.DBConnection;

@WebServlet("/testdb")

public class TestDBServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        if (DBConnection.getConnection() != null) {
            res.getWriter().println("DATABASE CONNECTED SUCCESSFULLY");
        } else {
            res.getWriter().println("DATABASE CONNECTION FAILED");
        }
    }
}
