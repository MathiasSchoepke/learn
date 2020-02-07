package mathiasschoepke;

import java.io.Serializable;
import java.util.Iterator;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.PieChartModel;

import lombok.Getter;

@Named
@ViewScoped
public class StatisticsBean implements Serializable {
	private static final long serialVersionUID = 7611247169459368891L;

	@Getter
	private PieChartModel pieModel;

	@Getter
	@Inject
	DataBean databean;

	@PostConstruct
	public void init() {
		createPieModel();
	}

	private void createPieModel() {
		pieModel = new PieChartModel();

		int step1 = 0;
		int step2 = 0;
		int step3 = 0;
		int step4 = 0;
		int step5 = 0;

		for (Iterator<QuestionOpject> iter = databean.getData().getQuestionList().iterator(); iter.hasNext();) {
			QuestionOpject entry = iter.next();

			switch (entry.getRating()) {
				case 0 :
					step1++;
					break;
				case 1 :
					step2++;
					break;
				case 2 :
					step3++;
					break;
				case 3 :
					step4++;
					break;
				case 4 :
					step5++;
					break;
			}
			pieModel.set("Stufe 1", step1);
			pieModel.set("Stufe 2", step2);
			pieModel.set("Stufe 3", step3);
			pieModel.set("Stufe 4", step4);
			pieModel.set("Stufe 5", step5);

			// pieModel.setTitle("Simple Pie");
			pieModel.setLegendPosition("w");
			pieModel.setShadow(false);
		}
	}
}
