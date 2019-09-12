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
 * Servlet implementation class DoubleDaily
 */
@WebServlet("/DoubleDaily")
public class DoubleDaily extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoubleDaily() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Player player = (Player)session.getAttribute("player");
		int value = Integer.parseInt(request.getParameter("value"));
		int maxValue = player.getScore() < 1000 ? 1000 :player.getScore(); 
		if(value > maxValue) {
			request.setAttribute("msg", "Invalid value. Please enter again");
			request.getRequestDispatcher("doubleDaily.jsp").forward(request, response);
		}else {
			int num = Integer.parseInt(request.getParameter("num"));
			((Questions)session.getAttribute("questions")).getQuestion(num).setValue(value);
			request.getRequestDispatcher("GetQuestion").forward(request, response);
		}
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Player player = (Player)request.getSession().getAttribute("player");
		int maxValue = player.getScore() < 1000? 1000 : player.getScore();
		
		request.setAttribute("maxValue", maxValue);
		
		request.getRequestDispatcher("doubleDaily.jsp").forward(request, response);
		
	}

}
