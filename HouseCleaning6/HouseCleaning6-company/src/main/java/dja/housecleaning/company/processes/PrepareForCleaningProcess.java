package dja.housecleaning.company.processes;

import java.util.List;

import dja.housecleaning.company.internal.HouseCleaning;
import dja.housecleaning.company.jobpositions.Assistant;
import dja.housecleaning.company.jobpositions.Cleaner;
import other.things.CleaningSupply;
import other.things.CleaningTool;


public class PrepareForCleaningProcess {

	public Cleaner selectCleaner(CleaningInstructions instructions) {
		return HouseCleaning.COMPANY.getCleaner();
	}

	public List<CleaningSupply> getCleaningSupplies(CleaningInstructions instructions) {
		Assistant assistant = HouseCleaning.COMPANY.getAssistant();
		return assistant.getNeededCleaningSupplies(instructions);
	}

	public List<CleaningTool> getCleaningTools(CleaningInstructions instructions) {
		Assistant assistant = HouseCleaning.COMPANY.getAssistant();
		return assistant.getNeededCleaningTools(instructions);
	}

}
