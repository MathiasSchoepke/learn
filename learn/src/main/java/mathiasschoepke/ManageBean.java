package mathiasschoepke;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
public class ManageBean implements Serializable {
	private static final long serialVersionUID = -4829244622184322249L;

	@ManagedProperty(value="#{dataBean}")
	@Getter(AccessLevel.PUBLIC)
	@Setter
	private DataBean dataBean;
}
