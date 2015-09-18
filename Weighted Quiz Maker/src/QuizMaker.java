import java.util.*;
import java.io.*;

public class QuizMaker {
	
	// Instance Variables
	public ArrayList<List<String>> allQuestions = new ArrayList<List<String>>();
	public List<String> allCandidates = new ArrayList<String>();
	public ArrayList<List<Object>> Scores = new ArrayList<List<Object>>();

	public QuizMaker(int numQuestions, String questions) {

		String unParsedQuestions = questions;
		String temp = "";
	}
	// Default Constructor
	public QuizMaker(){}
	
	public void setQuestion(String question){
		List<String> leadQuestion = Arrays.asList(question);
		allQuestions.add(leadQuestion);
	}
	
	public void setQuestionAt(int position, String question){
		List<String> leadQuestion = Arrays.asList(question);
		allQuestions.add(position, leadQuestion);
	}
	
	public void setCandidate(String candidate){
		allCandidates.add(candidate);
		List<Object> thisList = Arrays.asList(candidate,0);
		Scores.add(thisList);
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
		
	}
	
	// Method:	"getQuestion(String)"
	// Purpose:	To Return the main question
	public String getQuestionAnswers(String question){
		
	}
	
}
