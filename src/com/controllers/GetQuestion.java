package com.controllers;

import java.io.IOException;
import javax.servlet.ServletConfig;
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
 * Servlet implementation class GetQuestion
 */
@WebServlet("/GetQuestion")
public class GetQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public GetQuestion() {
        super();
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		HttpSession session = request.getSession();
		Questions questions = (Questions)session.getAttribute("questions");
		Question question = questions.getQuestion(num);
		String path = "selectedQuestion.jsp";
		if(question.isCompleted()) {
			request.setAttribute("msg", "Question has been selected. Please select another question");
			path = "gameBoard.jsp";
		}else {
			question.setCompleted();
			questions.setNumCompletedQs();
			request.setAttribute("question", question);
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
