package springaop.model;

public class Circle {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Cricle setter");
		throw(new RuntimeException()); //testing @AfterReturn
	}
	
	public String setNameAndReturn(String name) {
		this.name=name;
		return name;
	}
}
