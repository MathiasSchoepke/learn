package mathiasschoepke;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@Named
@ViewScoped
public class MenuBean implements Serializable {
	private static final long serialVersionUID = -6099548527310926458L;
	
	@Getter
	@Setter
	private String page = "learn";
	
	public String changeContent(String page) {
		return page+".xhtml";
	}
}