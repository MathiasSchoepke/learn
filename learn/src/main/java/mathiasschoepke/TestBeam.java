package mathiasschoepke;

import javax.faces.bean.ManagedBean;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "editor")
public class TestBeam {

	@Getter(AccessLevel.PUBLIC)
	@Setter
	private String value = "Lombak Getter Test";
}