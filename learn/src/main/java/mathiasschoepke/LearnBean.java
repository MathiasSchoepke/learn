package mathiasschoepke;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.PrimeFaces;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

//@Named // Use @javax.faces.bean.ManagedBean on outdated environments.
@ManagedBean
@RequestScoped // Use @javax.faces.bean.RequestScoped on outdated environments.
public class LearnBean {

	@Getter
	private QuestionOpject questionObject;
	@Getter
	private Boolean showAnswer;

	@ManagedProperty(value = "#{dataBean}")
	@Getter
	@Setter
	private DataBean dataBean;

	@PostConstruct
	public void init() {
		questionObject = dataBean.getQuestionObject();
		showAnswer = dataBean.getShowAnswer();
	}
	
	public void doShowAnswer() {
		showAnswer = true;
		dataBean.setShowAnswer(true);
		PrimeFaces.Ajax currentAjax = PrimeFaces.current().ajax();
		currentAjax.update("learn");
	}
	
	public void answerRight() {
		System.out.println("right");
		System.out.println("last question:"+ questionObject.getQuestion());
		submit();
	}

	public void answerWrong() {
		System.out.println("wrong");
		System.out.println("last question:"+ questionObject.getQuestion());
		submit();
	}

	private void submit() {
		questionObject = dataBean.getNewQuestion();
		showAnswer = false;
		dataBean.setShowAnswer(false);
		PrimeFaces.Ajax currentAjax = PrimeFaces.current().ajax();
		currentAjax.update("learn");
	}
}