package com.models;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.io.FileReader;
import java.io.BufferedReader;

public class Questions implements Serializable {
	private String filePath;
	private Question[] questions = new Question[25];
	private int[] doubleDailies = new int[2];
	private int numCompletedQs = 0;
	
	public Questions() {}	
	public Questions(String path) {
		this.filePath = path;
		this.loadQuestion();
		this.setDoubleDailies();
	}
	
	public String getFilePath() {return filePath; }
	public void setFilePath(String path) {
		filePath = path;
	}
	
	public Question[] getQuestions() { return questions; }
	public void setQuestions(Question[] questions) {
		this.questions = questions;
	}
	
	public Question getQuestion(int index) { return questions[index]; }
	public void setQuestion(int index, Question question) {
		questions[index] = question;
	}
	
	public int getNumCompletedQs() {return numCompletedQs; }
	public void setNumCompletedQs() {
		numCompletedQs++;
	}
	
	public int[] getDoubleDailies() { return doubleDailies; }
	public void setDoubleDailies() {
		int num1 = (int)(Math.random()*25);
		int num2 = (int)(Math.random()*25);
		while(num2 == num1) {
			num2 = (int)(Math.random()*25);
		}
		doubleDailies[0] = num1;
		doubleDailies[1] = num2;
		System.out.println("Double daily are " + (num1+1) + " and " + (num2+1));
	}
	
	public int getDoubleDaily(int index) { return doubleDailies[index]; }
	public void setDoubleDaily(int index, int value) {
		doubleDailies[index] = value;
	}
	
	public boolean isDoubleDaily(int num) {
		return doubleDailies[0] == num || doubleDailies[1] == num;
	}
	
	private void loadQuestion() {
		File file = new File(filePath);
		if(!file.exists()) {
			System.out.println("Questions File not found");
			return;
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			for(int i = 0; i < 25; i++) {
				if((line = br.readLine()) == null)
						break;
				String[] parts = line.split(";");
				questions[i] = new Question(
							parts[0], // category
							parts[1], // question
							parts[2], // answer 1
							parts[3], // answer 2
							parts[4], // answer 3
							parts[5], // answer 4
							parts[6], // correct answer
							Integer.parseInt(parts[7]) //score
						);
			}
			br.close();
			System.out.println("DOne loading questions");
		}catch(IOException err) {
			err.getMessage();
		}catch(NumberFormatException err) {
			err.getMessage();
		}
	}
	
	
	
}
