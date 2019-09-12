URL: localhost:8080/Jeopardy/login.html
Browser: Google Chrome
Starter file: /WebContent/login.html

The application is started by running the /WebContent/login.html. 
Once the application is deployed, open Chrome browswer and enter
the URL above. This will take to the login page where the player
enters his name to begin the game session. After submitting the username,
the player will be taken to gameBoard.jsp that contains a list of 
questions to answer. Upon selecting a question, the player will be taken to 
selectedQuestion.jsp, where he can answer the question.  If lucky, the player 
will be taken to doubleDaily.jsp to enter amount of money the question is work before 
the question is presented. After submitting the answer, the player will be 
taken back to the gameBoard.jsp to continue answering the remaining questions.
The player has one chance to skip a question without penalty at selectedQuestion.jsp, 
and it will take him back to the gameBoard.jsp. After completing all 25 questions,
the player will be taken to endGame.html that displays the total point he's earned

