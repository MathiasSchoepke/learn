package mathiasschoepke;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import lombok.Getter;

@ManagedBean
@ApplicationScoped
public class DataBean implements Serializable {
	private static final long serialVersionUID = 7964334770565974366L;

	@Getter
	private List<QuestionOpject> questionList;

	@PostConstruct
	public void init() {
		questionList = Arrays.asList(
				new QuestionOpject(0, "Wie heißt der höhste Berg Deutschlands?", "Die Zugspitze (2962 m)"),
				new QuestionOpject(15, "Wie viele Bundesländer hat Deuntschland?", "16"),
				new QuestionOpject(78, "Wann gewann Deutschland den Eurovision?", "Berlin"),
				new QuestionOpject(78, "Wie heißt die Hauptstandt von Deuntschland?", "1982 und 2010"),
				new QuestionOpject(78, "Wann und wie oft war Deutschland Fußball-Weltmeister?", "1954, 1974, 1990, 2014"));
	}

}
