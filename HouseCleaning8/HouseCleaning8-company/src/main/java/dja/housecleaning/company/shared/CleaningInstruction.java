package dja.housecleaning.company.shared;

import java.util.List;

public interface CleaningInstruction {

	public enum Room {
		KITCHEN, BEDROOM, LIVINGROOM, BATHROOM
	}

	public enum Service {
		vacuumTheFloor, washTheFloor, wipeTheDust
	}

	public Room getRoom();
	public List<Service> getToDo();
}
