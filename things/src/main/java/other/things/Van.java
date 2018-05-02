package other.things;

import java.util.List;

public class Van {

	
	public void drive (String place) {
		System.out.println("🚚 : Going to " + place);
	}

	public void load (List<? extends Object> things) {
		System.out.println("🚚 : Loaded " + things );
	}

	public void addPassenger (Object person) {
		System.out.println("🚚 : passenger " + person );
	}

}
