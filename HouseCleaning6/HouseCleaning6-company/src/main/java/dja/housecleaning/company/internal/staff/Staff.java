package dja.housecleaning.company.internal.staff;

import dja.housecleaning.company.jobpositions.Accountant;
import dja.housecleaning.company.jobpositions.Assistant;
import dja.housecleaning.company.jobpositions.Cleaner;
import dja.housecleaning.company.jobpositions.Receptionist;

public class Staff {

	public static final Staff ALL = new Staff();
	
	private Staff() {
	}

	public Receptionist getReceptionist() {
		return Ronald.PERSON;
	}

	public Accountant getAccountant() {
		return Harry.PERSON;
	}

	public Assistant getAssistant() {
		return Andrey.PERSON;
	}

	public Cleaner getCleaner() {
		return Harry.PERSON;
	}
}
