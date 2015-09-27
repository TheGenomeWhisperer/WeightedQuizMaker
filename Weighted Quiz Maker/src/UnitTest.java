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
		for (int i = 0; i < test.allQuestions.size(); i++){
			System.out.println(test.allQuestions.get(i).get(0));
		}
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
		System.out.println(test.getWinner());
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
		int num = test.getNumWinners();
		System.out.println(num);
		Scanner names = new Scanner(test.getWinner());
		if (num > 1) {
			System.out.println("You are tied in compatibility with " + num + " Candidates!\nThey are:");
			while(names.hasNext()){
				System.out.println(names.next());
			}
		}
		names.close();
	}
	
	@Test
	public void setAnswerTest(){
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
		test.setQuestion(Q1);
		test.setQuestion(Q2);
		test.setCandidate(C1);
		test.setCandidate(C3);
		test.setCandidate(C2);
		test.setCandidate(C4);
//		test.setAnswerChoice(Q1, A1);
		for (int i = 0; i <test.allQuestions.size(); i++){
			System.out.println(test.allQuestions.get(i).get(0));
		}
//		for (int i = 0; i < test.answerWeights.size(); i++){
//			System.out.println(test.answerWeights.get(i).get(0));
//		}
//		
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
		System.out.println(test.answerWeights.get(0).size());
		for(int i = 0; i < test.answerWeights.get(0).size(); i++){

			System.out.println(test.answerWeights.get(0).get(i));
		}
	}

}
