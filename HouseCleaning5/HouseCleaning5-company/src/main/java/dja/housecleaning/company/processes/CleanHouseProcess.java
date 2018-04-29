package dja.housecleaning.company.processes;

import java.util.List;

import dja.housecleaning.company.HouseCleaning;
import dja.housecleaning.company.jobpositions.Assistant;
import dja.housecleaning.company.jobpositions.Cleaner;
import dja.housecleaning.company.jobpositions.Receptionist;
import dja.housecleaning.company.policies.CleaningInstructions;
import other.things.CleaningSupply;
import other.things.CleaningTool;

public class CleanHouseProcess {

	TransportProcess transportProcess = new TransportProcess();
	
	public void cleanHouse (String address, List<String> instructions) {
		
		Receptionist receptionist = HouseCleaning.COMPANY.getReceptionist();
		CleaningInstructions cleaningInstructions = receptionist.prepareCleaningInstructions(address, instructions);
		
		Assistant assistant = HouseCleaning.COMPANY.getAssistant();
		List<CleaningTool> neededCleaningTools = assistant.getNeededCleaningTools(cleaningInstructions);
		List<CleaningSupply> neededCleaningSupplies = assistant.getNeededCleaningSupplies(cleaningInstructions);
		
		Cleaner cleaner = HouseCleaning.COMPANY.getCleaner();
		
		transportProcess.goTo(address, cleaner, neededCleaningSupplies, neededCleaningTools);
		cleaner.cleanHouse(cleaningInstructions);
		transportProcess.goTo("office", cleaner, neededCleaningSupplies, neededCleaningTools);
		
		assistant.putCleaningSuppliesToStorage(neededCleaningSupplies);
		assistant.putCleaningToolsInStorage(neededCleaningTools);

	}
}
