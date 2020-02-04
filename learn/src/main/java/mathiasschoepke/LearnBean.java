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
	
	@Getter(AccessLevel.PUBLIC)
	private QuestionOpject questionObject;

	@PostConstruct
	public void init() {
		questionObject = getRandomEntryFromList(dataBean.getQuestionList());
	}
	private QuestionOpject getRandomEntryFromList(List<QuestionOpject> list) {
		int randomInt = new Random().nextInt(list.size());
		return list.get(randomInt);
	}

	public void answerRight() {
		questionObject = getRandomEntryFromList(dataBean.getQuestionList());
	}

	public void answerWrong() {
		questionObject = getRandomEntryFromList(dataBean.getQuestionList());
	}
}