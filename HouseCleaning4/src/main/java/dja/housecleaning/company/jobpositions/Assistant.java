package dja.housecleaning.company.jobpositions;

import java.util.List;

import dja.housecleaning.company.processes.CleaningInstructions;
import other.things.CleaningSupply;
import other.things.CleaningTool;

public interface Assistant {

	List<CleaningSupply> getNeededCleaningSupplies(CleaningInstructions instructions);

	List<CleaningTool> getNeededCleaningTools(CleaningInstructions instructions);

	void putCleaningSuppliesToStorage (List<CleaningSupply> cleaningSupplies);

	void putCleaningToolsInStorage (List<CleaningTool> cleaningTools);
}
