package dja.housecleaning.company.processes;

import dja.housecleaning.company.jobpositions.Cleaner;
import dja.housecleaning.company.shared.CleaningInstructions;

public class CleanHouseProcess {

	
	public void cleanHouse (Cleaner cleaner, CleaningInstructions cleaningInstructions) {
				
		cleaner.cleanHouse(cleaningInstructions);

	}
}
