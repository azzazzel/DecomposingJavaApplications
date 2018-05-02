package dja.housecleaning.company.processes;

import java.util.LinkedList;
import java.util.List;

public class CleaningInstructions {

	public String address;

	public List<Instruction> instructions = new LinkedList<>();

	public static class Instruction {
		public enum Room {
			KITCHEN, BEDROOM, LIVINGROOM, BATHROOM
		}
		public enum Service {
			vacuumTheFloor, washTheFloor, wipeTheDust
		}
		public Room room;
		public List<Service> what;
	}
}
