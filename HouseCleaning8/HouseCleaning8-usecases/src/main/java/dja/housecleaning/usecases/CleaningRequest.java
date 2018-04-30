package dja.housecleaning.usecases;

import java.util.List;

import org.joda.money.Money;
import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface CleaningRequest {

	String getAddress ();
	
	Money getPayment();
	
	List<String> getInstructions ();
	
	void fixPayment(Money expected, Money received);

//	String getCustomerName();
}
