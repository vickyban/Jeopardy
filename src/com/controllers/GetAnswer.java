package com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.models.Player;
import com.models.Question;
import com.models.Questions;

/**
 * Servlet implementation class GetAnswer
 */
@WebServlet("/GetAnswer")
public class GetAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetAnswer() {
        super();
    }
    
    // If skip the question
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	HttpSession session = request.getSession();
    	Questions questions = (Questions)session.getAttribute("questions");
    	Player player = (Player)session.getAttribute("player");
    	player.setSkip();
    	if(questions.getNumCompletedQs() == 25) {
    		String msg = this.getEndMessage(player.getScore());		
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("endGame.jsp").forward(request, response);
		}else {
			response.sendRedirect("gameBoard.jsp");
		}
    }
    
    // if answer the question
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String answer = request.getParameter("answer");
		System.out.print("answer is null " + (answer == null) );
		int num = Integer.parseInt(request.getParameter("num"));
		
		HttpSession session = request.getSession();
    	Questions questions = (Questions)session.getAttribute("questions");
    	Player player = (Player)session.getAttribute("player");
    	
    	Question question = questions.getQuestion(num);
    	question.setSelectedAnswer(answer);

		if(question.isCorrectAnswer(answer)) {
			player.addScore(question.getValue());
		}else {
			player.substractScore(question.getValue());
		}
		
		if(questions.getNumCompletedQs() == 25) {
			String msg = this.getEndMessage(player.getScore());		
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("endGame.jsp").forward(request, response);
		}else {
			response.sendRedirect("gameBoard.jsp");
		}
		
	}
	private String getEndMessage(int score) {
		String msg =  "You got " + score + " points!";
		msg = msg + (score < 1000 ? "Geez you sucked! Go back to study!!!" : "Wow you're so smart!!!");
		return msg;
	}


}
