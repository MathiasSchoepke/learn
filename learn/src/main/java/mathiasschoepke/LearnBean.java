package mathiasschoepke;

import java.io.Serializable;
//import java.util.Arrays;
//import java.util.List;

//import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
//import javax.faces.event.ActionEvent;

import lombok.AccessLevel;
import lombok.Getter;
//import lombok.Setter;

@ManagedBean
@ViewScoped
public class LearnBean implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2775484532876202439L;
	@Getter(AccessLevel.PUBLIC)
	private String question = "Wie heißt der höhste Berg Deutschlands?";
	@Getter(AccessLevel.PUBLIC)
	private String answer = "Antwort: Die Zugspitze (2962 m)";
}