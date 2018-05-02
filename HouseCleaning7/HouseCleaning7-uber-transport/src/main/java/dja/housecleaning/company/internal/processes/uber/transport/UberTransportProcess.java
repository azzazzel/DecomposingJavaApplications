package dja.housecleaning.company.internal.processes.uber.transport;

import java.util.List;

import dja.housecleaning.company.jobpositions.Cleaner;
import dja.housecleaning.company.processes.TransportProcess;
import other.things.CleaningSupply;
import other.things.CleaningTool;

public class UberTransportProcess implements TransportProcess {

	@Override
	public void goTo(String address, Cleaner cleaner, List<CleaningSupply> supplies, List<CleaningTool> tools) {
		
		System.out.println("🚗 : Order Uber Van!");
		System.out.println("🚗 : Load supplies and tools");
		System.out.println("🚗 : Go to " + address);

	}

	@Override
	public boolean isCurrentlyAvailable() {
		return true;
	}

	@Override
	public int priority() {
		return 100;
	}

	
}
