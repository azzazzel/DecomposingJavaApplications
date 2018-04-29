package dja.housecleaning.test;

import org.junit.Test;

import dja.housecleaning.HarryHouse;


public class TestHauseCleaning {

	@Test
	public void howItWorks() {

		HarryHouse harryHouse = HarryHouse.PERSON;
		harryHouse.cleanHouseOrder("some street", "clean the widows", 200);
		
	}

}
