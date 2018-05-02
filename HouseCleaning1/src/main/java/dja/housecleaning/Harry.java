package dja.housecleaning;

import java.util.ArrayList;
import java.util.List;

import other.things.BookkeepingSystem;
import other.things.CleaningSupply;
import other.things.CleaningSupplyStore;
import other.things.CleaningTool;
import other.things.Van;

public class Harry {

	private List<CleaningTool> myCleaningTools = new ArrayList<>();
	private List<CleaningSupply> myCleaningSupplies = new ArrayList<>();
	private Van myVan = new Van();
	private BookkeepingSystem bookkeepingSystem = new BookkeepingSystem();
	
	public static final Harry PERSON = new Harry();
	
	private Harry() {
		myCleaningTools.add(new CleaningTool("vaccume cleaner"));
		myCleaningTools.add(new CleaningTool("floor mop"));
		myCleaningTools.add(new CleaningTool("glass wiper"));
		// ... 
		myCleaningSupplies.add(CleaningSupplyStore.purchase("carpet cleaner"));
		myCleaningSupplies.add(CleaningSupplyStore.purchase("wood cleaner"));
		myCleaningSupplies.add(CleaningSupplyStore.purchase("glass cleaner"));
		// ... 
	}		

	public void cleanHouse (String address, String instructions, double money) {
		if (money < 100) {
			System.out.println("Harry: You need to pay me more!");
			return;
		}
		
		System.out.println("Harry: Pick cleaning supplies based on provided instructions");
		List<CleaningTool> neededCleaningTools = new ArrayList<>();
		for (CleaningTool cleaningTool : myCleaningTools) {
			// some filter logic here
			neededCleaningTools.add(cleaningTool);
		}

		System.out.println("Harry: Pick cleaning tools based on provided instructions");
		List<CleaningSupply> neededCleaningSupplies = new ArrayList<>();
		for (CleaningSupply cleaningSupply : myCleaningSupplies) {
			// some filter logic here
			neededCleaningSupplies.add(cleaningSupply);
		}
		
		myVan.load(myCleaningSupplies);
		myVan.load(myCleaningTools);
		myVan.addPassenger(this);
		myVan.drive(address);
		
		System.out.println("Harry: cleaning 💦");
		System.out.println("Harry: done cleaning 🌟");

		myVan.load(myCleaningSupplies);
		myVan.load(myCleaningTools);
		myVan.addPassenger(this);
		myVan.drive("back to my office");
		
		System.out.println("Harry: Checking supplies ");
		for (CleaningSupply cleaningSupply : neededCleaningSupplies) {
			if (cleaningSupply.isEmpty()) {
				// purchase 
			}
		}

		bookkeepingSystem.recordIncome(money);		
	}
	
	public Van borrowVan (String who) {
		if ("friend".equals(who)) {
			System.out.println("Harry: Here is my 🚚️");
			return myVan;	
		}
		System.out.println("Harry: I'm sorry but I don't know you!");
		return null;
	}

	public List<CleaningTool> borrowTools (String who) {
		if ("friend".equals(who)) {
			System.out.println("Harry: Here are my 🛠️");
			return myCleaningTools;
		}
		System.out.println("Harry: I'm sorry but I don't know you!");
		return null;
	}

	@Override
	public String toString() {
		return "Harry";
	}
}
