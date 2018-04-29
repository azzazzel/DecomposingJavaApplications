package dja.housecleaning.test;

import org.junit.Test;

import dja.housecleaning.Garage;
import dja.housecleaning.HarryHouse;
import dja.housecleaning.backoffice.Storage;
import dja.housecleaning.frontoffice.CleanOrderForm;
import dja.housecleaning.frontoffice.Receptionist;


public class TestHauseCleaning {

	@Test
	public void howItWorks() {

		System.out.println("--------------------");
		System.out.println("official way ...");
		System.out.println("--------------------");
		Receptionist frontOffice = Receptionist.PERSON;
		CleanOrderForm cleanOrderForm = frontOffice.getOrderForm();
		cleanOrderForm.setAddress("some street");
		cleanOrderForm.setInstructions("clean the floor");
		frontOffice.cleanMyHousePlease(cleanOrderForm, 200);
		
	}

	@Test
	public void howItShouldNotWork() {

		System.out.println("--------------------");
		System.out.println("call Harry ...");
		System.out.println("--------------------");
		HarryHouse harryHouse = HarryHouse.PERSON;
		harryHouse.cleanHouseOrder("some street", "clean the widows", 200);
		
	}

	@Test
	public void dontMessWithMyStorage() {

		Storage storage = Storage.PLACE;
		storage.myCleaningSupplies.get(0);

		System.out.println("--------------------");
		System.out.println("oops I just messed up with your storage ...");
		System.out.println("--------------------");

	}

	@Test
	public void dontMessWithMyGarage() {

		Garage garage = Garage.PLACE;
		garage.getMyVan();

		System.out.println("--------------------");
		System.out.println("oops I just messed up with your garage ...");
		System.out.println("--------------------");

	}

}
