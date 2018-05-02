package dja.housecleaning.frontoffice;

import dja.housecleaning.HarryHouse;

public class Receptionist {

	public static final Receptionist PERSON = new Receptionist();
	
	private Receptionist() {
	}
	
	public void pleaseCleanMyHouse (OrderForm orderForm, double money) {
		HarryHouse.PERSON.cleanHouseOrder(orderForm.getAddress(), orderForm.instructions, money);
	}	

	public OrderForm getOrderForm () {
		return new OrderForm();
	}	

}
