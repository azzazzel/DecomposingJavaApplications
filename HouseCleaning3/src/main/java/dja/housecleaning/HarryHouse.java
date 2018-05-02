package dja.housecleaning;

import java.util.List;

import dja.housecleaning.backoffice.Assistant;
import other.things.BookkeepingSystem;
import other.things.CleaningSupply;
import other.things.CleaningSupplyStore;
import other.things.CleaningTool;
import other.things.Van;

public class HarryHouse {

	public static final HarryHouse PERSON = new HarryHouse();

	private BookkeepingSystem bookkeepingSystem = new BookkeepingSystem();
	
	private HarryHouse() {
		Assistant assistant = Assistant.PERSON;
		assistant.putInStorage(new CleaningTool("vaccume cleaner"));
		assistant.putInStorage(new CleaningTool("floor mop"));
		assistant.putInStorage(new CleaningTool("glass wiper"));
		// ... 
		assistant.putInStorage(CleaningSupplyStore.purchase("carpet cleaner"));
		assistant.putInStorage(CleaningSupplyStore.purchase("wood cleaner"));
		assistant.putInStorage(CleaningSupplyStore.purchase("glass cleaner"));
		// ... 
	}		
			
	public void cleanHouseOrder (String address, String instructions, double money) {
		if (money < 100) {
			System.out.println("You need to pay me more!");
			return;
		}
		Assistant assistant = Assistant.PERSON;
		List<CleaningTool> neededCleaningTools = assistant.getNeededCleaningTools(instructions);
		List<CleaningSupply> neededCleaningSupplies = assistant.getNeededCleaningSupplies(instructions);
		Van myVan = Garage.PLACE.getMyVan();
		myVan.drive(address);
		cleanTheHouse(neededCleaningTools, neededCleaningSupplies);
		myVan.drive("back to my office");
		for (CleaningSupply cleaningSupply : neededCleaningSupplies) {
			if (cleaningSupply.isEmpty()) {
				assistant.putInStorage(CleaningSupplyStore.purchase(cleaningSupply.getName()));
			} else {
				assistant.putInStorage(cleaningSupply);
			}
		}
		for (CleaningTool cleaningTool : neededCleaningTools) {
			assistant.putInStorage(cleaningTool);
		}
		bookkeepingSystem.recordIncome(money);
	}


	private void cleanTheHouse(List<CleaningTool> cleaningDevices, List<CleaningSupply> cleaningSupplies) {
		System.out.println("started cleaning");
		// your cleaning "business logic" here
		System.out.println("done cleaning");
	}

}
