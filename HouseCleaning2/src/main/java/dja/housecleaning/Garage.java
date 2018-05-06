package dja.housecleaning;

import java.util.ArrayList;
import java.util.List;

import other.things.CleaningSupply;
import other.things.CleaningTool;
import other.things.Van;

class Garage {

	private List<CleaningTool> cleaningTools = new ArrayList<>();
	private List<CleaningSupply> leaningSupplies = new ArrayList<>();
	private Van van = new Van();
	
	public static final Garage PLACE = new Garage();
	
	private Garage() {
	}
	
	public void add (CleaningTool cleaningTool) {
		cleaningTools.add(cleaningTool);
	}

	public void add (CleaningSupply cleaningSupply) {
		leaningSupplies.add(cleaningSupply);
	}

	public List<CleaningTool> getCleaningTools() {
		return cleaningTools;
	}

	public List<CleaningSupply> getCleaningSupplies() {
		return leaningSupplies;
	}

	public List<CleaningSupply> getNeededCleaningSupplies(String instructions) {
		System.out.println("Smart garage: SELECT cleaning supplies FROM garage WHERE supplies LIKE provided instructions");
		List<CleaningSupply> neededCleaningSupplies = new ArrayList<>();
		for (CleaningSupply cleaningSupply : leaningSupplies) {
			// some filter logic here
			neededCleaningSupplies.add(cleaningSupply);
		}
		return neededCleaningSupplies;
	}

	public List<CleaningTool> getNeededCleaningTools(String instructions) {
		System.out.println("Smart garage: SELECT cleaning tools FROM garage WHERE tools LIKE provided instructions");
		List<CleaningTool> neededCleaningTools = new ArrayList<>();
		for (CleaningTool cleaningTool : cleaningTools) {
			neededCleaningTools.add(cleaningTool);
		}
		return neededCleaningTools;
	}

	public Van getVan() {
		return van;
	}

	
}
