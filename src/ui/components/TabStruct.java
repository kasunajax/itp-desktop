package ui.components;

public class TabStruct {

	private Class<?> c;
	private String t;
	
	public TabStruct(Class<?> c, String t) {
		this.c = c;
		this.t= t;
	}
	
	public String getTitle() {
		return t;
	}
	
	public Class<?> getTab(){
		return c;
	}
}
