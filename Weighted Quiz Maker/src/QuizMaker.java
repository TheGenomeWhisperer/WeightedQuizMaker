import java.util.*;
import java.io.*;

public class QuizMaker {
	
	// Instance Variables
	public List<String> allQuestions = new ArrayList<String>();
	public List<String> allCandidates = new ArrayList<String>();
	public ArrayList<List<Object>> Scores = new ArrayList<List<Object>>();

	public QuizMaker(int numQuestions, String questions) {

		String unParsedQuestions = questions;
		String temp = "";

	}
	

	public void setQuestion(String question)
	{
		allQuestions.add(question);
	}
	
	public void setQuestionAt(int position, String question){
		allQuestions.add(position, question);
	}
	
	public void setCandidate(String candidate){
		allCandidates.add(candidate);
		List<Object> thisList = Arrays.asList(candidate,0);
		Scores.add(thisList);
	}
	
	public int getScore(String candidate){
		for (int i = 0; i < Scores.size(); i++){
			for (int j = 0; j < 1; j++){
				if (Scores.get(i).get(j).equals(candidate)){
					return (int) Scores.get(i).get(j + 1);
				}
			}
		}
		// Failure to find value, so returning Zero by default.
		return 0;
	}

	public String getWinner()
	{
		String winner = "";
		return winner;
	}
	
	
}
