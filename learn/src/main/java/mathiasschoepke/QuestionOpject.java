package mathiasschoepke;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionOpject{

	private int id;
	private String question;
	private String answer;
	private int rating;
	
	public QuestionOpject(int id, String question, String answer, int rating) {
		this.id = id;
		this.question = question;
	    this.answer = answer;
		this.rating = rating;
	  }
}