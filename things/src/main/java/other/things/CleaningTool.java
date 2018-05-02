package other.things;

public class CleaningTool {

	String name;
	
	public String getName() {
		return name;
	}

	public CleaningTool(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return getName();
	}

}
