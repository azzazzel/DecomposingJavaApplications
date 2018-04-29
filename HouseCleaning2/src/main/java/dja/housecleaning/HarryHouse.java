package dja.housecleaning;

import java.util.List;

import other.things.BookkeepingSystem;
import other.things.CleaningSupply;
import other.things.CleaningSupplyStore;
import other.things.CleaningTool;
import other.things.Van;

public class HarryHouse {

	public static final HarryHouse PERSON = new HarryHouse();

	private BookkeepingSystem bookkeepingSystem = new BookkeepingSystem();
	
	private HarryHouse() {
		Garage garage = Garage.PLACE;
		garage.add(new CleaningTool("vaccume cleaner"));
		garage.add(new CleaningTool("floor mop"));
		garage.add(new CleaningTool("glass wiper"));
		// ... 
		garage.add(CleaningSupplyStore.purchase("carpet cleaner"));
		garage.add(CleaningSupplyStore.purchase("wood cleaner"));
		garage.add(CleaningSupplyStore.purchase("glass cleaner"));
		// ... 
	}		
			
	public void cleanHouseOrder (String address, String instructions, double money) {
		if (money < 100) {
			return;
		}
		Garage garage = Garage.PLACE;
		List<CleaningTool> neededCleaningTools = garage.getNeededCleaningTools(instructions);
		List<CleaningSupply> neededCleaningSupplies = garage.getNeededCleaningSupplies(instructions);
		Van myVan = garage.getMyVan();
		myVan.drive(address);
		cleanTheHouse(neededCleaningTools, neededCleaningSupplies);
		myVan.drive("back to my office");
		for (CleaningSupply cleaningSupply : neededCleaningSupplies) {
			if (cleaningSupply.isEmpty()) {
				garage.add(CleaningSupplyStore.purchase(cleaningSupply.getName()));
			} else {
				garage.add(cleaningSupply);
			}
		}
		for (CleaningTool cleaningTool : neededCleaningTools) {
			garage.add(cleaningTool);
		}
		bookkeepingSystem.recordIncome(money);
	}


	private void cleanTheHouse(List<CleaningTool> cleaningDevices, List<CleaningSupply> cleaningSupplies) {
		System.out.println("started cleaning");
		// your cleaning "business logic" here
		System.out.println("done cleaning");
	}

}
