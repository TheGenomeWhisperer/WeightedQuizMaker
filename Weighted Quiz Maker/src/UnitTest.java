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

}
