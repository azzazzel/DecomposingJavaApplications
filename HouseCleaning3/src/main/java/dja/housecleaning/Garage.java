package dja.housecleaning;

import other.things.Van;

public class Garage {

	private Van myVan = new Van();
	
	public static final Garage PLACE = new Garage();
	
	private Garage() {
	}
	
	public Van getMyVan() {
		return myVan;
	}

	
}
