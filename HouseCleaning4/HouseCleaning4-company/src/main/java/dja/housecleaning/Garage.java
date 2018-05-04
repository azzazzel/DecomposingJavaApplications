package dja.housecleaning;

import other.things.Van;

class Garage {

	private Van myVan = new Van();
	
	public static final Garage PLACE = new Garage();
	
	private Garage() {
	}
	
	public Van getVan() {
		return myVan;
	}

	
}
