<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

  <link href="styles/selectedQuestionStyle.css" rel="stylesheet" type="text/css" />
  <title>Document</title>
</head>

<body>
  <div id="header" class="center">
    <div id="box1">Jeopardy</div>
    <div id="box2">Player: ${player.name}</div>
    <div id="box3">Points: ${player.score}</div>
  </div>

  <div id="main" class="center">
    <h4>Category: ${question.catergory}</h4>
    <h2>Question: ${question.question}</h2>
    <form action="GetAnswer" method="post">
    	<input type="hidden" name="num" value="${param.num}" />
      <div id="inputs">
        <label class="radio">
          <input type="radio" name="answer" value="${question.answer1}" />
          <span>${question.answer1}</span>
        </label>
        <label class="radio">
          <input type="radio" name="answer" value="${question.answer2}" />
          <span>${question.answer2}</span>
        </label>
        <label class="radio">
          <input type="radio" name="answer" value="${question.answer3}" />
          <span>${question.answer3}</span>
        </label>
        <label class="radio">
          <input type="radio" name="answer" value="${question.answer4}" />
          <span>${question.answer4}</span>
        </label>
      </div>

      <input type="submit" value="Submit" />
      <c:if test="${player.canSkip()}">
        <a href="GetAnswer?skip=true" id="skipBtn">Skip</a>
      </c:if>
    </form>
  </div>
</body>

</html>