import java.util.*;

public class QuizMaker {
	
	// Instance Variables
	public List<String> allCandidates = new ArrayList<String>();
	public ArrayList<List<String>> allQuestions = new ArrayList<List<String>>();
	public ArrayList<List<Object>> Scores = new ArrayList<List<Object>>();
	public ArrayList<List<Object>> answerWeights = new ArrayList<List<Object>>();

	// Default Constructor
	public QuizMaker(){
		// Initializing the weighted column, eliminating array[0][0] position with a null.
		// This ensures all added answer questions and qualifying candidates fill the rest of the Row/Columns
		List<Object> list = new ArrayList<Object>();
		list.add("");
		answerWeights.add(0,list);
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

	public void setQuestion(String question){
		List<String> leadQuestion = new ArrayList<>();
		leadQuestion.add(question);
		allQuestions.add(leadQuestion);
	}
	
	public void setQuestionAt(int position, String question){
		// Makes position play nice with array index.
		position = position -1;
		List<String> leadQuestion = new ArrayList<>();
		leadQuestion.add(question);
		allQuestions.add(position, leadQuestion);
	}
	
	public void setCandidate(String candidate){
		allCandidates.add(candidate);
		List<Object> thisList = Arrays.asList(candidate,0);
		Scores.add(thisList);
		// Now adding default weights for candidate for each question choice option.
		int index = 0;
		List<Object> list = new ArrayList<>();
		list.add(candidate);
		answerWeights.add(list);
		// Determining index of where it was placed
		for (int i = 0; i < answerWeights.size(); i++){
			if (answerWeights.get(i).equals(candidate)){
				index = i;
			}
		}
		// Defaulting all possible answers to zero for the given candidate.
		for (int i = 1; i < answerWeights.get(0).size(); i++){
			answerWeights.get(index).add(i,0);
		}
	}
	
	public void setAnswerChoice(String question, String answer){
		for (int i = 0; i < allQuestions.size(); i++){
			if (allQuestions.get(i).get(0).equals(question)){
				allQuestions.get(i).add(answer);
				break;
			}
		}
		// Now set default weight to zero for all candidates.
		answerWeights.get(0).add(answer);
		int index = answerWeights.get(0).indexOf(answer);
		for (int i = 1; i < answerWeights.size(); i++){
			answerWeights.get(i).add(index,0);
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
		// Now removing it from weighted options
		removeAnswerFromWeights(answer);
	}
	
	private void removeAnswerFromWeights(String answer) {
		int index = answerWeights.get(0).indexOf(answer);
		for (int i = 0; i < answerWeights.size(); i++){
			answerWeights.get(i).remove(index);
		}
	}
	
	public void setWeight(String candidate, String answer, int weight){
		int index = 0;
		for (int i = 1; i < answerWeights.size(); i++) {
			if (answerWeights.get(i).get(0).equals(candidate)){
				index = i;
			}
		}
		for (int i = 1; i < answerWeights.get(0).size(); i++){
			if (answerWeights.get(0).get(i).equals(answer)){
				answerWeights.get(index).set(i,weight);
			}
		}
	}
	
	public int getWeight(String candidate, String answer){
		int weight = 0;
		int index = 0;
		for (int i = 1; i < answerWeights.size(); i++) {
			if (answerWeights.get(i).get(0).equals(candidate)){
				index = i;
			}
		}
		for (int i = 1; i < answerWeights.get(0).size(); i++){
			if (answerWeights.get(0).get(i).equals(answer)){
				weight = (int)answerWeights.get(index).get(i);
			}
		}
		return weight;
	}
	
	public void resetWeightForQuestion(){
		
	}
	
	public void restAllWeights(){
		
	}
	
	public void removeCandidate(String candidate){
		// Remove from allCandidates
		for (int i = 0; i < allCandidates.size(); i++){
			if (allCandidates.get(i).equals(candidate)){
				allCandidates.remove(i);
				break;
			}
		}
		// Remove from smaller reference List
		for (int i = 0; i < Scores.size(); i++){
			if (Scores.get(i).get(0).equals(candidate)){
				Scores.get(i).remove(0);
				break;
			}
		}
		// Remove all associated Weights
		for (int i = 0; i < answerWeights.size(); i++){
			if (answerWeights.get(i).get(0).equals(candidate)){
				answerWeights.remove(i);
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
			// Removing answer options from the weights
			for (int i = 1; i < allQuestions.get(index).size(); i++){
				removeAnswerFromWeights(allQuestions.get(index).get(i));
			}
			// Full removal of question with accompanying answers.
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
		int highScore = -1;
		String winners = "";
		for (int i = 0; i < Scores.size(); i++){
			if((int)Scores.get(i).get(1) > highScore){
				highScore = (int)Scores.get(i).get(1);
				winners = (String)Scores.get(i).get(0) + " ";
			}
			else if ((int)Scores.get(i).get(1) == highScore){
				winners += (String)Scores.get(i).get(0) + " ";
			}
		}
		return winners.trim();
	}
	
	public int getNumWinners(){
		int numWinners = 1;
		String winners = getWinner();
		Scanner names = new Scanner(winners);
		if (winners.contains(" ")){
			names.next();
			while (names.hasNext()){
				numWinners++;
				names.next();
			}
		}
		names.close();
		return numWinners;
	}
	
	// Method:	"getQuestion(String)"
	// Purpose:	To Return the main question
	public String getQuestion(int num){
		// Getting number to play nicely with the index of the arrays.
		num = num - 1;
		return allQuestions.get(num).get(0);
	}
	
	public String[] getAllQuestionAnswers(String question){
		String[] questions = null;
		for (int i =0; i < allQuestions.size(); i++){
			if(allQuestions.get(i).get(0).equals(question)){
				questions = new String[allQuestions.get(i).size()-1];
				int index = 0;
				for (int j = 1; j < allQuestions.get(i).size(); j++){
					questions[index] = allQuestions.get(i).get(j);
					index++;
				}
			}
		}
		return questions;
	}
	
}
