package dja.housecleaning.company.internal.jobpositions;

import org.joda.money.Money;

import dja.housecleaning.company.Employee;

public interface Accountant extends Employee {

	void recordIncome(Money money);

}
