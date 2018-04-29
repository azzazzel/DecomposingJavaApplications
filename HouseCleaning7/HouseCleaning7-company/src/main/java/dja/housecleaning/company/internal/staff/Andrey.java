package dja.housecleaning.company.internal.staff;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dja.housecleaning.company.internal.HouseCleaning;
import dja.housecleaning.company.internal.assets.Storage;
import dja.housecleaning.company.internal.policies.CleaningInstructions;
import dja.housecleaning.company.internal.jobpositions.Assistant;
import other.things.CleaningSupply;
import other.things.CleaningSupplyStore;
import other.things.CleaningTool;

public class Andrey implements Assistant {

	public static final Andrey PERSON = new Andrey();

	Storage storage = HouseCleaning.COMPANY.getStorage();

	private Andrey() {
	}
	
	@Override
	public List<CleaningSupply> getNeededCleaningSupplies(CleaningInstructions instructions) {
		List<CleaningSupply> neededCleaningSupplies = new ArrayList<>();
		Iterator<CleaningSupply> cleaningSuppliesIterator = storage.cleaningSupplies.iterator();
		while (cleaningSuppliesIterator.hasNext()) {
			// if ( cleaningSupply is needed according to instructions ) {
				neededCleaningSupplies.add(cleaningSuppliesIterator.next());
				cleaningSuppliesIterator.remove();
			//}
		}
		return neededCleaningSupplies;
	}

	@Override
	public List<CleaningTool> getNeededCleaningTools(CleaningInstructions instructions) {
		List<CleaningTool> neededCleaningTools = new ArrayList<>();
		Iterator<CleaningTool> cleaningToolsIterator = storage.cleaningTools.iterator();
		while (cleaningToolsIterator.hasNext()) {
			// if ( cleaningTool is needed according to instructions ) {
				neededCleaningTools.add(cleaningToolsIterator.next());
				cleaningToolsIterator.remove();
			//}
		}
		return neededCleaningTools;
	}

	@Override
	public void putCleaningSuppliesToStorage(List<CleaningSupply> cleaningSupplies) {
		for (CleaningSupply cleaningSupply : cleaningSupplies) {
			if (cleaningSupply.isEmpty()) {
				storage.cleaningSupplies.add(CleaningSupplyStore.purchase(cleaningSupply.getName()));
			} else {
				storage.cleaningSupplies.add(cleaningSupply);
			}
		}
	}

	@Override
	public void putCleaningToolsInStorage(List<CleaningTool> cleaningTools) {
		storage.cleaningTools.addAll(cleaningTools);
	}

}
