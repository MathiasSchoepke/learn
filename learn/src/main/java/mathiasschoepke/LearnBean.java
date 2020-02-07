package mathiasschoepke;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

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
		questionObject = getRandomEntryFromList(dataBean.getData().getQuestionList());
		showAnswer = false;
	}
	
	public void doShowAnswer() {
		showAnswer = true;
		PrimeFaces.Ajax currentAjax = PrimeFaces.current().ajax();
		currentAjax.update("learn");
	}

	public void submit(Boolean isAnswerCorrect) {
		showAnswer = false;
		dataBean.rateQuestion(questionObject.getId(), isAnswerCorrect);
		questionObject = getNewQuestion(questionObject);
		PrimeFaces.Ajax currentAjax = PrimeFaces.current().ajax();
		currentAjax.update("learn");
	}

	public QuestionOpject getNewQuestion(QuestionOpject oldQuestion) {
		QuestionOpject newQuestion;

		do {
			newQuestion = getRandomEntryFromList(dataBean.getData().getQuestionList());
		} while (newQuestion.getId() == oldQuestion.getId());

		questionObject = newQuestion;
		return newQuestion;
	}

	private QuestionOpject getRandomEntryFromList(List<QuestionOpject> list) {
		int randomInt = new Random().nextInt(list.size());
		return list.get(randomInt);
	}
}