package dja.housecleaning.backoffice;

import java.util.ArrayList;
import java.util.List;

import other.things.CleaningSupply;
import other.things.CleaningTool;

public class Andrey {
	
	Storage storage = Storage.PLACE;
	
	public static final Andrey PERSON = new Andrey();

	private Andrey() {
	}
	
	public List<CleaningSupply> getNeededCleaningSupplies(String instructions) {
		System.out.println("Andrey: pick cleaning supplies based on provided instructions");
		List<CleaningSupply> neededCleaningSupplies = new ArrayList<>();
		for (CleaningSupply cleaningSupply : storage.getCleaningSupplies()) {
			// some filter logic here
			neededCleaningSupplies.add(cleaningSupply);
		}
		return neededCleaningSupplies;
	}

	public List<CleaningTool> getNeededCleaningTools(String instructions) {
		System.out.println("Andrey: pick cleaning tools based on provided instructions");
		List<CleaningTool> neededCleaningTools = new ArrayList<>();
		for (CleaningTool cleaningTool : storage.getCleaningTools()) {
			// some filter logic here
			neededCleaningTools.add(cleaningTool);
		}
		return neededCleaningTools;
	}
	
	public void storeCleaningTools(List<CleaningTool> cleaningTools) {
		System.out.println("Andrey: putting cleaning tools in storage");
		//
	}

	public void storeCleaningSupplies(List<CleaningSupply> cleaningSupplies) {
		System.out.println("Andrey: checking and putting cleaning supplies in storage");
		for (CleaningSupply cleaningSupply : cleaningSupplies) {
			if (cleaningSupply.isEmpty()) {
				// purchase 
			} 
		}
		//
	}

	public  List<CleaningTool> getCleaningTools () {
		return storage.getCleaningTools();
	}
	
	@Override
	public String toString() {
		return "Andrey";
	}
}
