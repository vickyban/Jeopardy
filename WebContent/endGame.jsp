<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.models.Questions"%>
<%@ page import="com.models.Question"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="styles/endGameStyle.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<div id="header" class="center">
		<div id="box1">Jeopardy</div>
		<div id="box2">Player: ${player.name}</div>
		<div id="box3">Points: ${player.score}</div>
	</div>

	<div id="main" class="center">
		<h2>Results</h2>
		<div>
			<table>
				<tr>
					<th>Question</th>
					<th>Worth</th>
					<th>Correct Answer</th>
					<th>Your Answer</th>
					<th>Earned</th>
				</tr>
				<%
					Question[] questions = ((Questions) session.getAttribute("questions")).getQuestions();
					for (int i = 0; i < 25; i++) {
						Question qs = questions[i];
						String sign = qs.isCorrectAnswer(qs.getSelectedAnswer()) ? "+" : "-";
						int value = qs.getSelectedAnswer() == null ? 0 : qs.getValue();
						String selectedAnswer = qs.getSelectedAnswer() == null ? "Skipped" : qs.getSelectedAnswer();
				%>
				<tr>
					<td style="text-align:left;"><%= i+". " + qs.getQuestion() %></td>
					<td><%= qs.getValue() %></td>
					<td><%= qs.getCorrectAnswer() %></td>
					<td><%= selectedAnswer %></td>
					<td><%= sign + value %></td>
				</tr>

				<%
					}
				%>
			</table>

		</div>
		<div id="final_msg">
			<img
				src="https://media1.tenor.com/images/134f83f8cf69f071ad7664ec297f956e/tenor.gif?itemid=7537724" />
			<div id="outer_bubble">
				<div id="talk_bubble">
					<h2>${msg}</h2>
				</div>
				<a href="login.html">New Game</a>
			</div>
		</div>
	</div>
	<% session.invalidate(); %>
</body>
</html>