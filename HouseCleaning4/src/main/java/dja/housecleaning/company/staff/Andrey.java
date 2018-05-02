package dja.housecleaning.company.staff;

import java.util.ArrayList;
import java.util.List;

import dja.housecleaning.company.assets.Storage;
import dja.housecleaning.company.jobpositions.Assistant;
import dja.housecleaning.company.processes.CleaningInstructions;
import other.things.CleaningSupply;
import other.things.CleaningTool;

class Andrey implements Assistant {

	public static final Andrey PERSON = new Andrey();

	private Storage storage = Storage.PLACE;

	private Andrey() {
	}
	
	@Override
	public List<CleaningSupply> getNeededCleaningSupplies(CleaningInstructions instructions) {
		System.out.println("Andrey: pick cleaning supplies based on provided instructions");
		List<CleaningSupply> neededCleaningSupplies = new ArrayList<>();
		for (CleaningSupply cleaningSupply : storage.getCleaningSupplies()) {
			// some filter logic here
			neededCleaningSupplies.add(cleaningSupply);
		}
		return neededCleaningSupplies;
	}

	@Override
	public List<CleaningTool> getNeededCleaningTools(CleaningInstructions instructions) {
		System.out.println("Andrey: pick cleaning tools based on provided instructions");
		List<CleaningTool> neededCleaningTools = new ArrayList<>();
		for (CleaningTool cleaningTool : storage.getCleaningTools()) {
			// some filter logic here
			neededCleaningTools.add(cleaningTool);
		}
		return neededCleaningTools;
	}

	@Override
	public void storeCleaningTools(List<CleaningTool> cleaningTools) {
		System.out.println("Andrey: putting cleaning tools in storage");
		//
	}

	@Override
	public void storeCleaningSupplies(List<CleaningSupply> cleaningSupplies) {
		System.out.println("Andrey: checking and putting cleaning supplies in storage");
		for (CleaningSupply cleaningSupply : cleaningSupplies) {
			if (cleaningSupply.isEmpty()) {
				// purchase 
			}
		}
		//
	}

	@Override
	public String toString() {
		return "Andrey";
	}
}
