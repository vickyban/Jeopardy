package com.models;
import java.io.Serializable;
import java.util.HashSet;

public class Player implements Serializable {
	private String name;
	private int score;
	private boolean skip;
//	private HashSet<Integer> completedQuestions = new HashSet<>();
	
	public Player() {this.score = 0; skip= true;}
	
	public Player(String name) {
		this.name = name;
		score = 0;
		skip = true;
	}

	public String getName() {return name; }
	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {return score; }
	public void setScore(int score) {
		this.score = score;
	}
	
	
	public boolean canSkip() { return skip; }
	public void setSkip() {
		skip = false;
	}
	
	public int addScore(int score) {
		return this.score += score;
	}
	
	public int substractScore(int score) {
		return this.score -= score;	
	}
	
//	public void addCompletedQuestion(int n) {
//	completedQuestions.add(n);
//}
//
//public boolean hasCompletedQs(int n) {
//	return completedQuestions.contains(n);
//}
//	public int getCompletedQuestionSize() {
//		return completedQuestions.size();
//	}
	
}
