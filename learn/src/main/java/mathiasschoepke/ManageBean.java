package mathiasschoepke;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
//import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
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

	@ManagedProperty(value="#{dataBean}")
	@Getter(AccessLevel.PUBLIC)
	@Setter
	private DataBean dataBean;

	@PostConstruct
	public void init() {
		questionList = dataBean.getQuestionList();
	}
}
