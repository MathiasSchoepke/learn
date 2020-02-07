package mathiasschoepke;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {
	private List<QuestionOpject> questionList;

	public void CreateMockaList() {
		questionList = new ArrayList<QuestionOpject>();
		questionList.add(new QuestionOpject(0, "Wie heißt der höhste Berg Deutschlands?", "Die Zugspitze (2962 m)", 1));
		questionList.add(new QuestionOpject(15, "Wie viele Bundesländer hat Deutschland?", "16", 3));
		questionList.add(new QuestionOpject(78, "Wie heißt die Hauptstandt von Deutschland?", "Berlin", 4));
		questionList.add(new QuestionOpject(80, "Wann gewann Deutschland den Eurovision?", "1982 und 2010", 1));
		questionList.add(new QuestionOpject(91, "Wann und wie oft war Deutschland Fußball-Weltmeister?", "1954, 1974, 1990, 2014", 0));
	}
}
