package dja.housecleaning.company.internal.processes.uber.transport;

import java.util.List;

import dja.housecleaning.company.Employee;
import dja.housecleaning.company.processes.TransportProcess;
import other.things.CleaningSupply;
import other.things.CleaningTool;

public class UberTransportProcess implements TransportProcess {

	@Override
	public void goTo(String address, Employee cleaner, List<CleaningSupply> supplies, List<CleaningTool> tools) {
		
		System.out.println("Order Uber Van!");
		System.out.println("Load supplies and tools");
		System.out.println("Go to " + address);

	}

	@Override
	public boolean isCurrentlyAvailable() {
		return true;
	}

	
}
