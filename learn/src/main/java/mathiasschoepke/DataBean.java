package mathiasschoepke;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

//import lombok.AccessLevel;
import lombok.Getter;

@Named
@ApplicationScoped
public class DataBean implements Serializable {
	private static final long serialVersionUID = 7964334770565974366L;

	@Getter
	private List<QuestionOpject> questionList;

	@PostConstruct
	public void init() {
		questionList = new ArrayList<QuestionOpject>();
		questionList.add(new QuestionOpject(0, "Wie heißt der höhste Berg Deutschlands?", "Die Zugspitze (2962 m)"));
		questionList.add(new QuestionOpject(15, "Wie viele Bundesländer hat Deutschland?", "16"));
		questionList.add(new QuestionOpject(78, "Wie heißt die Hauptstandt von Deutschland?", "Berlin"));
		questionList.add(new QuestionOpject(80, "Wann gewann Deutschland den Eurovision?", "1982 und 2010"));
		questionList.add(new QuestionOpject(91, "Wann und wie oft war Deutschland Fußball-Weltmeister?", "1954, 1974, 1990, 2014"));
		// questionList = Arrays.asList(new QuestionOpject(0, "Wie heißt der
		// höhste Berg Deutschlands?", "Die Zugspitze (2962 m)"),
		// new QuestionOpject(15, "Wie viele Bundesländer hat Deutschland?",
		// "16"),
		// new QuestionOpject(78, "Wie heißt die Hauptstandt von Deutschland?",
		// "Berlin"),
		// new QuestionOpject(80, "Wann gewann Deutschland den Eurovision?",
		// "1982 und 2010"),
		// new QuestionOpject(91, "Wann und wie oft war Deutschland
		// Fußball-Weltmeister?", "1954, 1974, 1990, 2014"));
	}

	public void addQuestion(String question, String answer) {
		questionList.add(new QuestionOpject(questionList.size(), question, answer));
	}

	public void editQuestion(int id, String question, String answer) {
		// find entry
		QuestionOpject entry = null;
		for (Iterator<QuestionOpject> iter = questionList.listIterator(); iter.hasNext();) {
			QuestionOpject a = iter.next();
			if (a.getId() == id) {
				entry = a;
			}
		}
		// edit entry
		if (entry != null) {
			entry.setQuestion(question);
			entry.setAnswer(answer);
		}
	}

	public void removeQuestion(int id) {
		// find entry
		QuestionOpject entry = null;
		for (Iterator<QuestionOpject> iter = questionList.listIterator(); iter.hasNext();) {
			QuestionOpject a = iter.next();
			if (a.getId() == id) {
				entry = a;
			}
		}
		// remove entry
		if (entry != null) {
			questionList.remove(entry);
		}
	}
}
