package dja.housecleaning.company.processes;

import java.util.List;

import org.joda.money.Money;
import org.osgi.annotation.versioning.ProviderType;

import dja.housecleaning.company.shared.CleaningInstructions;
import dja.housecleaning.company.shared.InsufficientAmountException;

@ProviderType
public interface NewOrderProcess {

	void checkPayment (Money money) throws InsufficientAmountException;

	CleaningInstructions prepareInstructions (String address, List<String> clientInstructions);

}