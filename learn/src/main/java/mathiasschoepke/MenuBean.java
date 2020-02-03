package mathiasschoepke;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
public class MenuBean implements Serializable {
	
	@Getter(AccessLevel.PUBLIC)
	@Setter(AccessLevel.PUBLIC)
	private String page = "exercises";
	
}