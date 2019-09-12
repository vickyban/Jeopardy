package com.models;

import java.io.Serializable;

public class Question implements Serializable {
	private String catergory;
	private String question;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private String correctAnswer;
	private int value;
	private String selectedAnswer = null;
	private boolean completed = false;
	
	public Question() {}
	
	public Question(String catergory, String question, String answer1, String answer2, String answer3,String answer4, String correctAnswer, int value) {
		this.catergory = catergory;
		this.question = question;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.correctAnswer = correctAnswer;
		this.value = value;	
	}

	public String getCatergory() { return catergory; }
	public void setCatergory(String catergory) {
		this.catergory = catergory;
	}

	public String getQuestion() { return question; }
	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer1() { return answer1; }
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() { return answer2; }
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() { return answer3; }
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getAnswer4() { return answer4; }
	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}
	
	public String getCorrectAnswer() { return correctAnswer; }
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public int getValue() { return value; }
	public void setValue(int value) {
		this.value = value;
	}
	
	public String getSelectedAnswer() { return selectedAnswer; }
	public void setSelectedAnswer(String selectedAnswer) {
		if(selectedAnswer == null)
			selectedAnswer = "No Answer";
		this.selectedAnswer = selectedAnswer;
	}

	public boolean isCorrectAnswer(String answer) {
		return this.correctAnswer.equals(answer);
	}

	public boolean isCompleted() {return completed;}
	public void setCompleted() {
		this.completed = true;
	}
		
}
