package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.models.Player;
import com.models.Questions;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		
		HttpSession session = request.getSession(false);
		if(session == null ) {
			session = request.getSession();
			Player player = new Player(username);
			Questions questions = new Questions(getServletContext().getRealPath("WEB-INF/questions.txt"));
			session.setAttribute("player", player);
			session.setAttribute("questions", questions);
		}
		response.sendRedirect("gameBoard.jsp");
	}
	

}
