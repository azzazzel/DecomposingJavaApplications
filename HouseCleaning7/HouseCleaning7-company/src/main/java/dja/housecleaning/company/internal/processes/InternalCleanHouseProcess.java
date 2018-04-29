package dja.housecleaning.company.internal.processes;

import java.util.List;
import java.util.ServiceLoader;

import dja.housecleaning.company.internal.HouseCleaning;
import dja.housecleaning.company.internal.policies.CleaningInstructions;
import dja.housecleaning.company.processes.CleanHouseProcess;
import dja.housecleaning.company.processes.TransportProcess;
import dja.housecleaning.company.internal.jobpositions.Assistant;
import dja.housecleaning.company.internal.jobpositions.Cleaner;
import dja.housecleaning.company.internal.jobpositions.Receptionist;
import other.things.CleaningSupply;
import other.things.CleaningTool;

public class InternalCleanHouseProcess implements CleanHouseProcess {

	
	/* (non-Javadoc)
	 * @see dja.housecleaning.company.internal.processes.CleanHouseProcess#cleanHouse(java.lang.String, java.util.List)
	 */
	@Override
	public void cleanHouse (String address, List<String> instructions) {
		
		Receptionist receptionist = HouseCleaning.COMPANY.getReceptionist();
		CleaningInstructions cleaningInstructions = receptionist.prepareCleaningInstructions(address, instructions);
		
		Assistant assistant = HouseCleaning.COMPANY.getAssistant();
		List<CleaningTool> neededCleaningTools = assistant.getNeededCleaningTools(cleaningInstructions);
		List<CleaningSupply> neededCleaningSupplies = assistant.getNeededCleaningSupplies(cleaningInstructions);
		
		Cleaner cleaner = HouseCleaning.COMPANY.getCleaner();

		ServiceLoader<TransportProcess> serviceLoader = ServiceLoader.load(TransportProcess.class);
		TransportProcess transportProcess = serviceLoader.stream()
				.map(provider -> provider.get())
				.filter(process -> process.isCurrentlyAvailable())
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No way to go to the house !!!"));

		transportProcess.goTo(address, cleaner, neededCleaningSupplies, neededCleaningTools);
		cleaner.cleanHouse(cleaningInstructions);
		transportProcess.goTo("office", cleaner, neededCleaningSupplies, neededCleaningTools);
		
		assistant.putCleaningSuppliesToStorage(neededCleaningSupplies);
		assistant.putCleaningToolsInStorage(neededCleaningTools);

	}
}
