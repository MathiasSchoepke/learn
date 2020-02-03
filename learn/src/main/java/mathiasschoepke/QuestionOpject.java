package mathiasschoepke;

import lombok.AccessLevel;
import lombok.Getter;

public class QuestionOpject{
	@Getter(AccessLevel.PUBLIC)
	private int id;
	@Getter(AccessLevel.PUBLIC)
	private String question;
	@Getter(AccessLevel.PUBLIC)
	private String answer;
	
	public QuestionOpject(int id, String question, String answer) {
		this.id = id;
		this.question = question;
	    this.answer = answer;
	  }
}