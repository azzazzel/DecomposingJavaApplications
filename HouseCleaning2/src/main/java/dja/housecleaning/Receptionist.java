package dja.housecleaning;

public class Receptionist {

	public static final Receptionist PERSON = new Receptionist();
	
	private Receptionist() {
	}
	
	public void cleanMyHousePlease (CleanOrderForm orderForm, double money) {
		HarryHouse.PERSON.cleanHouseOrder(orderForm.getAddress(), orderForm.instructions, money);
	}	

	public CleanOrderForm getOrderForm () {
		return new CleanOrderForm();
	}	

}
