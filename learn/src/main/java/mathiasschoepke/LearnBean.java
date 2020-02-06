package mathiasschoepke;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class LearnBean implements Serializable {
	private static final long serialVersionUID = 2586271925244067596L;

	@Getter
	private QuestionOpject questionObject;
	@Getter
	private Boolean showAnswer;

	@Getter
	@Setter
	@Inject
	DataBean dataBean;

	@PostConstruct
	public void init() {
		System.out.println(dataBean);
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