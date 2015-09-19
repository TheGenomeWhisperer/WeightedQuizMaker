import java.util.*;
import java.io.*;

public class QuizMaker {
	
	// Instance Variables
	public ArrayList<List<String>> allQuestions = new ArrayList<List<String>>();
	public List<String> allCandidates = new ArrayList<String>();
	public ArrayList<List<Object>> Scores = new ArrayList<List<Object>>();

	// Default Constructor
	public QuizMaker(){}
	
	public void setQuestion(String question){
		List<String> leadQuestion = Arrays.asList(question);
		allQuestions.add(leadQuestion);
	}
	
	public void setQuestionAt(int position, String question){
		// Makes position play nice with array index.
		position = position -1;
		List<String> leadQuestion = Arrays.asList(question);
		allQuestions.add(position, leadQuestion);
	}
	
	public void setCandidate(String candidate){
		allCandidates.add(candidate);
		List<Object> thisList = Arrays.asList(candidate,0);
		Scores.add(thisList);
	}
	
	public void addScore(String candidate, int num){
		for (int i = 0; i < Scores.size(); i++){
			if (Scores.get(i).get(0).equals(candidate)){
				int newNum = (int)Scores.get(i).get(1) + num;
				Scores.get(i).set(1, (Object)newNum);
				break;
			}
		}
	}
	
	public void setAnswerChoice(String question, String answer){
		for (int i = 0; i < allQuestions.size(); i++){
			if (allQuestions.get(i).get(0).equals(question)){
				allQuestions.get(i).add(answer);
				break;
			}
		}
	}
	
	public void removeAnswerChoice(String question, String answer){
		for (int i = 0; i < allQuestions.size(); i++){
			if (allQuestions.get(i).get(0).equals(question)){
				for (int j = 0; j < allQuestions.get(i).size(); j++) {
					if (allQuestions.get(i).get(j).equals(question)){
						allQuestions.get(i).remove(j);
						break;
					}
				}
				break;
			}
		}
	}
	public void removeCandidate(String candidate){
		// Remove from allCandidates
		for (int i = 0; i < allCandidates.size(); i++){
			if (allCandidates.get(i).equals(candidate)){
				allCandidates.remove(i);
				break;
			}
		}
		// Remove from thinner List
		for (int i = 0; i < Scores.size(); i++){
			if (Scores.get(i).get(0).equals(candidate)){
				Scores.get(i).remove(0);
				break;
			}
		}
	}
	
	public void removeQuestion(String question) {
		int index = -1;
		for (int i = 0; i < allQuestions.size(); i++){
			if (allQuestions.get(i).get(0).equals(question)){
				index = i;
				break;
			}
		}
		if (index == -1){
			System.out.println("Question Not Found");
		}
		else {
			allQuestions.remove(index);
		}
	}
	
	public void resetAllScores(){
		for (int i = 0; i < Scores.size(); i++){
			Scores.get(i).set(1, 0);
		}
	}
	
	public int getScore(String candidate){
		for (int i = 0; i < Scores.size(); i++){
			if (Scores.get(i).get(0).equals(candidate)){
				return (int) Scores.get(i).get(1);
			}
		}
		// Failure to find value, so returning Zero by default.
		return 0;
	}

	public String getWinner(){
		String winner = "";
		return winner;
	}
	public String getQuestion(int num){
		// Getting number to play nicely with the index of the arrays.
		num = num - 1;
		return allQuestions.get(num).get(0);
	}
	
	// Method:	"getQuestion(String)"
	// Purpose:	To Return the main question
	public String getQuestionAnswers(String question){
		return "";
	}
	
}
