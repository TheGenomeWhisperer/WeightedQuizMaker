import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class UnitTest {

	public UnitTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void setQuestionTest(){
		QuizMaker test = new QuizMaker();
		String Q1 = "How Are You Today?";
		String Q2 = "Tada!";
		String Q3 = "This is it!";
		String Q4 = "Test Successful!";
		test.setQuestion(Q1);
		test.setQuestion(Q2);
		test.setQuestion(Q4);
		test.setQuestion(Q3);
		assertEquals(Q1, test.getQuestion(1));
		assertEquals(Q2, test.getQuestion(2));
		assertTrue(Q4.equals(test.getQuestion(3)));
	}
	
	@Test
	public void getScoreTest(){
		QuizMaker test = new QuizMaker();
		String C1 = "Aaron";
		String C2 = "Abby";
		String C3 = "Allison";
		String C4 = "Amelia";
		test.setCandidate(C1);
		test.setCandidate(C3);
		test.setCandidate(C2);
		test.setCandidate(C4);
		test.addScore(C1, 5);
		test.addScore(C1, 3);
		test.addScore(C3, 18);
		test.addScore(C3, 2);
		test.addScore(C2, 999999);
		test.addScore(C4,0);
		assertTrue(test.getScore(C1) == 8);
		assertTrue(test.getScore(C3) == 20);
		assertEquals(0,test.getScore(C4));
		assertEquals(999999,test.getScore(C2));
	}
	
	@Test
	public void clearScoresTest(){
		QuizMaker test = new QuizMaker();
		String C1 = "Test";
		String C2 = "Test5";
		String C3 = "TestMe!";
		test.addScore(C3, 18);
		test.addScore(C3, 2);
		test.addScore(C2, 999999);
		test.resetAllScores();
		assertTrue(test.getScore(C1) == 0);
		assertTrue(test.getScore(C3) == 0);
		assertEquals(0,test.getScore(C2));
	}
	
	@Test
	public void getWinnerTest(){
		QuizMaker test = new QuizMaker();
		String C1 = "Aaron";
		String C2 = "Abby";
		String C3 = "Allison";
		String C4 = "Amelia";
		test.setCandidate(C1);
		test.setCandidate(C3);
		test.setCandidate(C2);
		test.setCandidate(C4);
		test.addScore(C1, 18);
		test.addScore(C1, 2);
		test.addScore(C3, 18);
		test.addScore(C3, 2);
		test.addScore(C2, 20);
		test.addScore(C4,0);
	}
	
	@Test
	public void getNumWinnersTest(){
		QuizMaker test = new QuizMaker();
		String C1 = "Aaron";
		String C2 = "Abby";
		String C3 = "Allison";
		String C4 = "Amelia";
		test.setCandidate(C1);
		test.setCandidate(C3);
		test.setCandidate(C2);
		test.setCandidate(C4);
		test.addScore(C1, 100);
		test.addScore(C1, 0);
		test.addScore(C3, 18);
		test.addScore(C3, 2);
		test.addScore(C2, 100);
		test.addScore(C4,100);
		assertEquals(3,test.getNumWinners());
		test.addScore(C4, 1);
		assertEquals(1,test.getNumWinners());
		test.addScore(C4, -1);
		assertEquals(3,test.getNumWinners());
	}
	
	@Test
	public void setAnswerAndQuestionsTest(){
		QuizMaker test = new QuizMaker();
		String C1 = "Aaron";
		String C2 = "Abby";
		String C3 = "Allison";
		String C4 = "Amelia";
		String Q1 = "What day is it?";
		String A1 = "Monday";
		String A1_2 = "Tuesday";
		String A1_3 = "Wednesday";
		String Q2 = "Today is a Good day, right?";
		String A2 = "Yes!";
		String A2_2 = "No!";
		String A2_3 = "It is Ok...";
		test.setQuestion(Q1);
		test.setQuestion(Q2);
		test.setCandidate(C1);
		test.setCandidate(C3);
		test.setCandidate(C2);
		test.setCandidate(C4);
		test.setAnswerChoice(Q1, A1);
		test.setAnswerChoice(Q1, A1_2);
		test.setAnswerChoice(Q1, A1_3);
		test.setAnswerChoice(Q2, A2);
		test.setAnswerChoice(Q2, A2_2);
		test.setAnswerChoice(Q2, A2_3);
		assertTrue(test.allQuestions.get(0).get(0).equals(Q1));
		assertTrue(test.allQuestions.get(0).get(1).equals(A1));
		assertTrue(test.allQuestions.get(1).get(3).equals(A2_3));
	}
	
	@Test
	public void setDefaultWeightTest(){
		QuizMaker test = new QuizMaker();
		String C1 = "Aaron";
		String C2 = "Abby";
		String C3 = "Allison";
		String C4 = "Amelia";
		String Q1 = "What day is it?";
		String A1 = "Monday";
		String A1_2 = "Tuesday";
		String A1_3 = "Wednesday";
		test.setCandidate(C1);
		test.setCandidate(C3);
		test.setCandidate(C2);
		test.setCandidate(C4);
		test.setQuestion(Q1);
		test.setAnswerChoice(Q1, A1);
		test.setAnswerChoice(Q1, A1_2);
		test.setAnswerChoice(Q1, A1_3);
		for(int i = 1; i < test.answerWeights.size(); i++){
			for (int j = 1; j < test.answerWeights.get(0).size(); j++) {
				assertTrue(test.answerWeights.get(i).get(j).equals(0));
			}
		}
	}
	
	@Test
	public void weightsTest(){
		QuizMaker test = new QuizMaker();
		String C1 = "Aaron";
		String C2 = "Abby";
		String C3 = "Allison";
		String C4 = "Amelia";
		String Q1 = "What day is it?";
		String A1 = "Monday";
		String A1_2 = "Tuesday";
		String A1_3 = "Wednesday";
		String Q2 = "Today is a Good day, right?";
		String A2 = "Yes!";
		String A2_2 = "No!";
		String A2_3 = "It is Ok...";
		test.setQuestion(Q1);
		test.setQuestion(Q2);
		test.setCandidate(C1);
		test.setCandidate(C3);
		test.setCandidate(C2);
		test.setCandidate(C4);
		test.setAnswerChoice(Q1, A1);
		test.setAnswerChoice(Q1, A1_2);
		test.setAnswerChoice(Q1, A1_3);
		test.setAnswerChoice(Q2, A2);
		test.setAnswerChoice(Q2, A2_2);
		test.setAnswerChoice(Q2, A2_3);
		test.setWeight(C1, A1, 5);
		test.setWeight(C1, A1_2, 0);
		test.setWeight(C1, A1_3, 1);
		assertEquals(5,test.getWeight(C1, A1));
		assertEquals(0,test.getWeight(C1, A1_2));
		test.setWeight(C1, A1, -5000);
		assertEquals(-5000,test.getWeight(C1, A1));
		test.setWeight(C2, A2, 42);
		test.setWeight(C2, A2_2, 15);
		test.setWeight(C2, A2_3, 1);
		assertEquals(42,test.getWeight(C2, A2));
		test.resetAllWeights();
		assertEquals(0,test.getWeight(C2, A2));
		assertEquals(0,test.getWeight(C1, A1));
		test.setWeight(C2, A2, 42);
		test.setWeight(C2, A2_2, 15);
		test.setWeight(C2, A2_3, 1);
		test.resetAllWeightsForAnswer(A2);
		int index = test.answerWeights.get(0).indexOf(A2);
		for (int i = 1; i < test.answerWeights.size(); i++){
			assertEquals(0,test.answerWeights.get(i).get(index));
		}
	}
}
