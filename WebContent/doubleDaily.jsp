<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.models.Player" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link href="styles/doubleDailyStyle.css" rel="stylesheet" type="text/css" />
<title>Double Daily</title>
</head>
<body>
  <div id="header" class="center">
    <div id="box1">Jeopardy</div>
    <div id="box2">Player: ${player.name}</div>
    <div id="box3">Points: ${player.score}</div>
  </div>

  <div id="main" class="center">
    <h2></h2>
    <h4>Please make a wager for the question between 0 to ${maxValue}</h4>
    <form action="DoubleDaily" method="post">
     <div>
     	 <label >Value:</label>
        <input type="number" name="value" required min=0 max=${maxValue} />
        <input type="hidden" name="num" value="${param.num}" />
     </div>

      <input type="submit" value="Submit" />
    </form>
  </div>
</body>
</html>