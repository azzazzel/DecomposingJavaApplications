package dja.housecleaning.company.internal.processes;

import java.util.Comparator;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

import dja.housecleaning.company.internal.HouseCleaning;
import dja.housecleaning.company.internal.jobpositions.Assistant;
import dja.housecleaning.company.internal.jobpositions.Cleaner;
import dja.housecleaning.company.internal.jobpositions.Receptionist;
import dja.housecleaning.company.internal.policies.CleaningInstructions;
import dja.housecleaning.company.processes.CleanHouseProcess;
import dja.housecleaning.company.processes.TransportProcess;
import other.things.CleaningSupply;
import other.things.CleaningTool;

@Component 
public class InternalCleanHouseProcess implements CleanHouseProcess {

	@Reference (
			policy = ReferencePolicy.DYNAMIC,
			policyOption = ReferencePolicyOption.GREEDY)
	volatile List<TransportProcess> transportProcesses;
	
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

		TransportProcess transportProcess = transportProcesses.stream()
				.sorted(Comparator.comparing(TransportProcess::priority))
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
