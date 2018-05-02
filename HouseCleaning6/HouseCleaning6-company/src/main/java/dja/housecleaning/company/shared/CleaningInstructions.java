package dja.housecleaning.company.shared;

import java.util.List;

public interface CleaningInstructions {

	public String getAddress();

	public List<CleaningInstruction> getInstructions();

}
