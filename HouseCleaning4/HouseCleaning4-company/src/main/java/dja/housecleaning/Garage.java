package dja.housecleaning;

import other.things.Van;

class Garage {

	private Van myVan = new Van();
	
	static final Garage PLACE = new Garage();
	
	private Garage() {
	}
	
	Van getVan() {
		return myVan;
	}

	
}
