<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.models.Player" %>
<%@ page import="com.models.Questions" %>
<%@ page import="com.models.Question" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="styles/gameBoard.css" rel="stylesheet" type="text/css" />

<title>Game Board</title>

</head>
<body> 
<body>
  <div id="header" class="center">
    <div id="box1">Jeopardy</div>
    <div id="box2">Player: ${player.name}</div>
    <div id="box3">Points: ${player.score}</div>
  </div>

  <div class="center cards">
  	
  	  <% Player player = (Player)session.getAttribute("player");
  	  	 Questions questions = (Questions)session.getAttribute("questions");
  	  	 Question question;
      	for(int i= 0; i < 5; i++){ %>
      		<div class='card'>
      		<div class='question'>
      		<h2><%= questions.getQuestion(i*5).getCatergory() %></h2>
      		</div>
	      		
	      		<%for(int j = 0; j < 5; j++ ){
	      			int index = i * 5 + j;
	      			question = questions.getQuestion(index);
	      			String url = "GetQuestion?num=";
	      			
		      		if(question.isCompleted()){ 
		      			out.println("<a href='#' class='disable'>" + question.getValue() +"</a>");
		      		}else{
		      			 if(questions.isDoubleDaily(index)){
		      				 url = "DoubleDaily?num=";
		      			 }
		      			out.println("<a href='" + url + index + "' class='active'>" + question.getValue() +"</a>");
		      		}
	      		}%>
	      		</div>
      <% } %>
  </div>

</body>

</body>
</html>