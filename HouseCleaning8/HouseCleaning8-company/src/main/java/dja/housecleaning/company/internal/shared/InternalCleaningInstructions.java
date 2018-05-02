package dja.housecleaning.company.internal.shared;

import java.util.LinkedList;
import java.util.List;

import dja.housecleaning.company.shared.CleaningInstruction;
import dja.housecleaning.company.shared.CleaningInstructions;

public class InternalCleaningInstructions implements CleaningInstructions {

	public String address;

	public List<CleaningInstruction> instructions = new LinkedList<>();

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public List<CleaningInstruction> getInstructions() {
		return instructions;
	}

}
