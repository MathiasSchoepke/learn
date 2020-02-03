package mathiasschoepke;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
//import javax.faces.event.ActionEvent;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@RequestScoped
public class LearnBean implements Serializable {
	private static final long serialVersionUID = -2775484532876202439L;
	
	@ManagedProperty(value="#{dataBean}")
	@Getter
	@Setter
	private DataBean dataBean;
	
	private int id = 0;
	@Getter(AccessLevel.PUBLIC)
	private String question = "Wie heißt der höhste Berg Deutschlands?";
	@Getter(AccessLevel.PUBLIC)
	private String answer = "Die Zugspitze (2962 m)";

	@PostConstruct
	public void init() {
		setQuestion(getRandomEntryFromList(dataBean.getQuestionList()));
	}

	private void setQuestion(QuestionOpject newQuestion) {
		id = newQuestion.getId();
		question = newQuestion.getQuestion();
		answer = newQuestion.getAnswer();
		
	}
	private QuestionOpject getRandomEntryFromList(List<QuestionOpject> list) {
		int randomInt = new Random().nextInt(list.size());
		return list.get(randomInt);
	}

	public void answerRight() {
		setQuestion(getRandomEntryFromList(dataBean.getQuestionList()));
	}

	public void answerFalse() {
		setQuestion(getRandomEntryFromList(dataBean.getQuestionList()));
	}
}