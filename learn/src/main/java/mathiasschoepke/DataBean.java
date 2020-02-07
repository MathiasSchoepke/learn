package mathiasschoepke;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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

	private ReadWriteDataFile rwdf = new ReadWriteDataFile("data.json");
	@Getter
	private Data data = new Data();

	@PostConstruct
	public void init() {
		data = rwdf.ReadFromFile();
		if (data == null) {
			data = new Data();
			data.CreateMockaList();
			System.out.println("Mocka");
		}
		// questionList = new ArrayList<QuestionOpject>();
		// questionList.add(new QuestionOpject(0, "Wie heißt der höhste Berg
		// Deutschlands?", "Die Zugspitze (2962 m)"));
		// questionList.add(new QuestionOpject(15, "Wie viele Bundesländer hat
		// Deutschland?", "16"));
		// questionList.add(new QuestionOpject(78, "Wie heißt die Hauptstandt
		// von Deutschland?", "Berlin"));
		// questionList.add(new QuestionOpject(80, "Wann gewann Deutschland den
		// Eurovision?", "1982 und 2010"));
		// questionList.add(new QuestionOpject(91, "Wann und wie oft war
		// Deutschland Fußball-Weltmeister?", "1954, 1974, 1990, 2014"));
		//
		// // GSON
		// GsonBuilder builder = new GsonBuilder();
		// Gson gson = builder.create();
		// String json = gson.toJson(questionList);
		// System.out.println(json);
		//
		// data.setQuestionList(questionList);
		//
		// rwdf.WriteToFile(data);

	}

	@PreDestroy
	public void preDestroy() {
		rwdf.WriteToFile(data);
	}

	public void addQuestion(String question, String answer) {
		data.getQuestionList().add(new QuestionOpject(data.getQuestionList().size(), question, answer, 0));
		rwdf.WriteToFile(data);
	}

	public void editQuestion(int id, String question, String answer) {
		QuestionOpject entry = getQuestionEntry(id);
		if (entry != null) {
			entry.setQuestion(question);
			entry.setAnswer(answer);
			rwdf.WriteToFile(data);
		}
	}

	public void removeQuestion(int id) {
		QuestionOpject entry = getQuestionEntry(id);
		if (entry != null) {
			data.getQuestionList().remove(entry);
			rwdf.WriteToFile(data);
		}
	}

	public void rateQuestion(int id, Boolean isAnswerCorrect) {
		QuestionOpject entry = getQuestionEntry(id);
		if (entry != null) {
			if (isAnswerCorrect) {
				entry.setRating(Math.min(entry.getRating() + 1, 4));
			} else {
				entry.setRating(0);
			}
			rwdf.WriteToFile(data);
		}
	}

	private QuestionOpject getQuestionEntry(int id) {
		QuestionOpject entry = null;
		for (Iterator<QuestionOpject> iter = data.getQuestionList().listIterator(); iter.hasNext();) {
			QuestionOpject a = iter.next();
			if (a.getId() == id) {
				entry = a;
			}
		}
		if (entry != null) {
			return entry;
		}
		return null;
	}

}
