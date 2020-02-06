package mathiasschoepke;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

//import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Named
@ApplicationScoped
public class DataBean implements Serializable {
	private static final long serialVersionUID = 7964334770565974366L;

	@Getter
	private List<QuestionOpject> questionList;

	@Getter
	@Setter
	private QuestionOpject questionObject;
	@Getter
	@Setter
	private Boolean showAnswer;

	@PostConstruct
	public void init() {
		questionList = Arrays.asList(
				new QuestionOpject(0, "Wie heißt der höhste Berg Deutschlands?", "Die Zugspitze (2962 m)"),
				new QuestionOpject(15, "Wie viele Bundesländer hat Deutschland?", "16"),
				new QuestionOpject(78, "Wie heißt die Hauptstandt von Deutschland?", "Berlin"),
				new QuestionOpject(80, "Wann gewann Deutschland den Eurovision?", "1982 und 2010"), new QuestionOpject(
						91, "Wann und wie oft war Deutschland Fußball-Weltmeister?", "1954, 1974, 1990, 2014"));
		questionObject = getRandomEntryFromList(questionList);
		showAnswer = false;
	}

	public QuestionOpject getNewQuestion() {
		QuestionOpject newQuestion;
		
		do {
			newQuestion = getRandomEntryFromList(questionList);
		} while (newQuestion.getId() == questionObject.getId());
		
		questionObject = newQuestion;
		return newQuestion;
	}
	
	private QuestionOpject getRandomEntryFromList(List<QuestionOpject> list) {
		int randomInt = new Random().nextInt(list.size());
		return list.get(randomInt);
	}
}
