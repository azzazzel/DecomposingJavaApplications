package dja.housecleaning.company.internal.processes;

import java.util.List;

import dja.housecleaning.company.internal.HouseCleaning;
import dja.housecleaning.company.jobpositions.Assistant;
import dja.housecleaning.company.jobpositions.Cleaner;
import dja.housecleaning.company.processes.CleaningInstructions;
import dja.housecleaning.company.processes.PrepareForCleaningProcess;
import other.things.CleaningSupply;
import other.things.CleaningTool;


public class InternalPrepareForCleaningProcess implements PrepareForCleaningProcess {

	@Override
	public Cleaner selectCleaner(CleaningInstructions instructions) {
		return HouseCleaning.COMPANY.getCleaner();
	}

	@Override
	public List<CleaningSupply> getCleaningSupplies(CleaningInstructions instructions) {
		Assistant assistant = HouseCleaning.COMPANY.getAssistant();
		return assistant.getNeededCleaningSupplies(instructions);
	}

	@Override
	public List<CleaningTool> getCleaningTools(CleaningInstructions instructions) {
		Assistant assistant = HouseCleaning.COMPANY.getAssistant();
		return assistant.getNeededCleaningTools(instructions);
	}

}
