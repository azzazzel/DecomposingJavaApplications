package dja.housecleaning.frontoffice;

import java.util.LinkedList;
import java.util.List;

public class OrderForm {

	String address;
	
	List<String> instructions = new LinkedList<>();

	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getInstructions() {
		return instructions;
	}

	public void addInstruction(String instruction) {
		this.instructions.add(instruction);
	}
}
