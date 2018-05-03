package dja.housecleaning.backoffice;

import java.util.ArrayList;
import java.util.List;

import other.things.CleaningSupply;
import other.things.CleaningSupplyStore;
import other.things.CleaningTool;

public class Storage {

	private List<CleaningTool> cleaningTools = new ArrayList<>();
	private List<CleaningSupply> cleaningSupplies = new ArrayList<>();

	public static final Storage PLACE = new Storage();

	private Storage() {
		cleaningTools.add(new CleaningTool("vaccume cleaner"));
		cleaningTools.add(new CleaningTool("floor mop"));
		cleaningTools.add(new CleaningTool("glass wiper"));
		// ... 
		cleaningSupplies.add(CleaningSupplyStore.purchase("carpet cleaner"));
		cleaningSupplies.add(CleaningSupplyStore.purchase("wood cleaner"));
		cleaningSupplies.add(CleaningSupplyStore.purchase("glass cleaner"));
		// ... 
	}

	public List<CleaningTool> getCleaningTools() {
		return cleaningTools;
	}

	public List<CleaningSupply> getCleaningSupplies() {
		return cleaningSupplies;
	}

	
}
