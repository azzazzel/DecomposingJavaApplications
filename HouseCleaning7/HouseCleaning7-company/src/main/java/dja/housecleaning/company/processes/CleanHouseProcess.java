package dja.housecleaning.company.processes;

import dja.housecleaning.company.jobpositions.Cleaner;
import dja.housecleaning.company.shared.CleaningInstructions;

public interface CleanHouseProcess {

	void cleanHouse(Cleaner cleaner, CleaningInstructions cleaningInstructions);

}