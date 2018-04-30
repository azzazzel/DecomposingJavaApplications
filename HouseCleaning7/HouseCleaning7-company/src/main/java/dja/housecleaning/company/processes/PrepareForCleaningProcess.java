package dja.housecleaning.company.processes;

import java.util.List;

import dja.housecleaning.company.jobpositions.Cleaner;
import other.things.CleaningSupply;
import other.things.CleaningTool;

public interface PrepareForCleaningProcess {

	Cleaner selectCleaner(CleaningInstructions instructions);

	List<CleaningSupply> getCleaningSupplies (CleaningInstructions instructions);

	List<CleaningTool> getCleaningTools (CleaningInstructions instructions);
}
