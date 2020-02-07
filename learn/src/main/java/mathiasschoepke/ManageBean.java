package mathiasschoepke;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class ManageBean implements Serializable {
	private static final long serialVersionUID = -4829244622184322249L;

	@Getter
	private List<QuestionOpject> questionList;

	@Getter
	@Setter
	private String addQuestion;
	@Getter
	@Setter
	private String addAnswer;
	@Getter
	@Setter
	private String editQuestion;
	@Getter
	@Setter
	private String editAnswer;

	@Getter
	@Setter
	private QuestionOpject selectedQuestion;

	@Getter(AccessLevel.PUBLIC)
	@Setter
	@Inject
	private DataBean dataBean;

	@PostConstruct
	public void init() {
		questionList = dataBean.getQuestionList();
	}

	public void addQuestion() {
		dataBean.addQuestion(addQuestion, addAnswer);
	}

	public void editQuestion() {
		dataBean.editQuestion(selectedQuestion.getId(), editQuestion, editAnswer);
	}

	public void removeQuestion() {
		dataBean.removeQuestion(selectedQuestion.getId());
	}
}
