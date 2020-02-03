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
import lombok.Setter;

@ManagedBean
@ViewScoped
public class MenuBean implements Serializable {
	private static final long serialVersionUID = -6099548527310926458L;
	
	@Getter(AccessLevel.PUBLIC)
	@Setter(AccessLevel.PUBLIC)
	private String page = "learn";
}