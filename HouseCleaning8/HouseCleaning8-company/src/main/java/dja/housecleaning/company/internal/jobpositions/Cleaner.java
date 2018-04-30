package dja.housecleaning.company.internal.jobpositions;

import dja.housecleaning.company.Employee;
import dja.housecleaning.company.internal.policies.CleaningInstructions;

public interface Cleaner extends Employee {

	public void cleanHouse (CleaningInstructions instructions);

}
