package dja.housecleaning.backoffice;

import java.util.ArrayList;
import java.util.List;

import other.things.CleaningSupply;
import other.things.CleaningTool;

public class Assistant {
	
	Storage storage = Storage.PLACE;
	
	public static final Assistant PERSON = new Assistant();

	public List<CleaningSupply> getNeededCleaningSupplies(String instructions) {
		List<CleaningSupply> neededCleaningSupplies = new ArrayList<>();
		for (CleaningSupply cleaningSupply : storage.myCleaningSupplies) {
			if (instructions.contains(cleaningSupply.getName())) {
				storage.myCleaningSupplies.remove(cleaningSupply);
				neededCleaningSupplies.add(cleaningSupply);
			}
		}
		return neededCleaningSupplies;
	}

	public List<CleaningTool> getNeededCleaningTools(String instructions) {
		List<CleaningTool> neededCleaningTools = new ArrayList<>();
		for (CleaningTool cleaningTool : storage.myCleaningTools) {
			if (instructions.contains(cleaningTool.getName())) {
				storage.myCleaningTools.remove(cleaningTool);
				neededCleaningTools.add(cleaningTool);
			}
		}
		return neededCleaningTools;
	}
	
	public void putInStorage(CleaningTool cleaningTool) {
		storage.myCleaningTools.add(cleaningTool);
	}

	public void putInStorage(CleaningSupply cleaningSupply) {
		storage.myCleaningSupplies.add(cleaningSupply);
	}
}
