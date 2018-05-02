package dja.housecleaning;

import java.util.ArrayList;
import java.util.List;

import other.things.CleaningSupply;
import other.things.CleaningTool;
import other.things.Van;

public class Garage {

	private List<CleaningTool> myCleaningTools = new ArrayList<>();
	private List<CleaningSupply> myCleaningSupplies = new ArrayList<>();
	private Van myVan = new Van();
	
	public static final Garage PLACE = new Garage();
	
	private Garage() {
	}
	
	public void add (CleaningTool cleaningTool) {
		myCleaningTools.add(cleaningTool);
	}

	public void add (CleaningSupply cleaningSupply) {
		myCleaningSupplies.add(cleaningSupply);
	}

	public List<CleaningTool> getMyCleaningTools() {
		return myCleaningTools;
	}

	public List<CleaningSupply> getMyCleaningSupplies() {
		return myCleaningSupplies;
	}

	public List<CleaningSupply> getNeededCleaningSupplies(String instructions) {
		List<CleaningSupply> neededCleaningSupplies = new ArrayList<>();
		for (CleaningSupply cleaningSupply : myCleaningSupplies) {
			if (instructions.contains(cleaningSupply.getName())) {
				myCleaningSupplies.remove(cleaningSupply);
				neededCleaningSupplies.add(cleaningSupply);
			}
		}
		return neededCleaningSupplies;
	}

	public List<CleaningTool> getNeededCleaningTools(String instructions) {
		List<CleaningTool> neededCleaningTools = new ArrayList<>();
		for (CleaningTool cleaningTool : myCleaningTools) {
			if (instructions.contains(cleaningTool.getName())) {
				myCleaningTools.remove(cleaningTool);
				neededCleaningTools.add(cleaningTool);
			}
		}
		return neededCleaningTools;
	}

	public Van getMyVan() {
		return myVan;
	}

	
}
