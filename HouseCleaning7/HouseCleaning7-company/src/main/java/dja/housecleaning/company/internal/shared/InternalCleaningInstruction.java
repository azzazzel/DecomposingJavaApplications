package dja.housecleaning.company.internal.shared;

import java.util.List;

import dja.housecleaning.company.shared.CleaningInstruction;

public class InternalCleaningInstruction implements CleaningInstruction {

	public Room room;
	
	public List<Service> todo;

	@Override
	public Room getRoom() {
		return room;
	}
	
	@Override
	public List<Service> getToDo() {
		return todo;
	}
}
