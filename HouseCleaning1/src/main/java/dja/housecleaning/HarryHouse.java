package dja.housecleaning;

import java.util.ArrayList;
import java.util.List;

import other.things.BookkeepingSystem;
import other.things.CleaningSupply;
import other.things.CleaningSupplyStore;
import other.things.CleaningTool;
import other.things.Van;

public class HarryHouse {

	private List<CleaningTool> myCleaningTools = new ArrayList<>();
	private List<CleaningSupply> myCleaningSupplies = new ArrayList<>();
	private Van myVan = new Van();
	private BookkeepingSystem bookkeepingSystem = new BookkeepingSystem();
	
	public static final HarryHouse PERSON = new HarryHouse();
	
	private HarryHouse() {
		myCleaningTools.add(new CleaningTool("vaccume cleaner"));
		myCleaningTools.add(new CleaningTool("floor mop"));
		myCleaningTools.add(new CleaningTool("glass wiper"));
		// ... 
		myCleaningSupplies.add(CleaningSupplyStore.purchase("carpet cleaner"));
		myCleaningSupplies.add(CleaningSupplyStore.purchase("wood cleaner"));
		myCleaningSupplies.add(CleaningSupplyStore.purchase("glass cleaner"));
		// ... 
	}		
			
	public void cleanHouseOrder (String address, String instructions, double money) {
		if (money < 100) {
			return;
		}
		List<CleaningTool> neededCleaningTools = new ArrayList<>();
		for (CleaningTool cleaningTool : myCleaningTools) {
			if (instructions.contains(cleaningTool.getName())) {
				myCleaningTools.remove(cleaningTool);
				neededCleaningTools.add(cleaningTool);
			}
		}
		List<CleaningSupply> neededCleaningSupplies = new ArrayList<>();
		for (CleaningSupply cleaningSupply : myCleaningSupplies) {
			if (instructions.contains(cleaningSupply.getName())) {
				myCleaningSupplies.remove(cleaningSupply);
				neededCleaningSupplies.add(cleaningSupply);
			}
		}
		myVan.drive(address);
		cleanTheHouse(neededCleaningTools, neededCleaningSupplies);
		myVan.drive("back to my office");
		for (CleaningSupply cleaningSupply : neededCleaningSupplies) {
			if (cleaningSupply.isEmpty()) {
				myCleaningSupplies.add(CleaningSupplyStore.purchase(cleaningSupply.getName()));
			} else {
				myCleaningSupplies.add(cleaningSupply);
			}
		}
		for (CleaningTool cleaningTool : neededCleaningTools) {
			myCleaningTools.add(cleaningTool);
		}
		bookkeepingSystem.recordIncome(money);
		
	}

	private void cleanTheHouse(List<CleaningTool> cleaningDevices, List<CleaningSupply> cleaningSupplies) {
		System.out.println("started cleaning");
		// your cleaning "business logic" here
		System.out.println("done cleaning");
	}

}
