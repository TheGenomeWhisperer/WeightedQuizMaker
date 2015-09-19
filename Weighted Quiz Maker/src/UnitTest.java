import static org.junit.Assert.*;

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

}
