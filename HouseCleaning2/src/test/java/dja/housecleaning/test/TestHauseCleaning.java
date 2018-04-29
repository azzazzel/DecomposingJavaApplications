package dja.housecleaning.test;

import org.junit.Test;

import dja.housecleaning.Garage;
import dja.housecleaning.CleanOrderForm;
import dja.housecleaning.Receptionist;
import dja.housecleaning.HarryHouse;


public class TestHauseCleaning {

	@Test
	public void howItWorks() {

		Receptionist frontOffice = Receptionist.PERSON;
		CleanOrderForm cleanOrderForm = frontOffice.getOrderForm();
		cleanOrderForm.setAddress("some street");
		cleanOrderForm.setInstructions("clean the floor");
		frontOffice.cleanMyHousePlease(cleanOrderForm, 200);
		
	}

	@Test
	public void howItShouldNotWork() {

		HarryHouse harryHouse = HarryHouse.PERSON;
		harryHouse.cleanHouseOrder("some street", "clean the widows", 200);
		
	}

	@Test
	public void dontMessWithMyGarage() {

		Garage garage = Garage.PLACE;
		garage.getMyVan().drive("somewhere");
		
	}

}
