package dja.housecleaning.frontoffice;

import java.util.List;

import org.joda.money.Money;

import dja.housecleaning.usecases.CleaningRequest;

public class FrontOfficeCleaningRequest implements CleaningRequest {

	String address;
	
	List<String> instructions;
	
	Money payment;
	
	public FrontOfficeCleaningRequest(String address, List<String> instructions, Money payment) {
		super();
		this.address = address;
		this.instructions = instructions;
		this.payment = payment;
	}

	@Override
	public String getAddress() {
		return address;
	}

	@Override
	public Money getPayment() {
		return payment;
	}

	@Override
	public List<String> getInstructions() {
		return instructions;
	}

	@Override
	public void fixPayment(Money expected, Money received) {
		
		System.out.println("Recived " + received + " but expected " + expected);
		System.out.println("Asking the customer to adjust payment");
		// ...
		System.out.println("Customer paid proper amount");
		
		this.payment = expected;
	}

}
