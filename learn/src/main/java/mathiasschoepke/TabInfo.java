package mathiasschoepke;

import lombok.AccessLevel;
import lombok.Getter;

public class TabInfo{
	@Getter(AccessLevel.PUBLIC)
	private String title;
	@Getter(AccessLevel.PUBLIC)
	private String page;
	
	public TabInfo(String title, String page) {
	    this.title = title;
	    this.page = page;
	  }
}