package dja.housecleaning.company.internal.processes;

import dja.housecleaning.company.jobpositions.Cleaner;
import dja.housecleaning.company.processes.CleanHouseProcess;
import dja.housecleaning.company.shared.CleaningInstructions;

public class InternalCleanHouseProcess implements CleanHouseProcess {

	
	@Override
	public void cleanHouse (Cleaner cleaner, CleaningInstructions cleaningInstructions) {
				
		cleaner.cleanHouse(cleaningInstructions);

	}
}
