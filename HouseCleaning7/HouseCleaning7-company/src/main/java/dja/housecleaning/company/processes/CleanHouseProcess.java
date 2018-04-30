package dja.housecleaning.company.processes;

import dja.housecleaning.company.jobpositions.Cleaner;

public interface CleanHouseProcess {

	void cleanHouse(Cleaner cleaner, CleaningInstructions cleaningInstructions);

}