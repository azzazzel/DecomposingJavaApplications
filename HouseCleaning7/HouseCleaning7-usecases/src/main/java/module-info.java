import dja.housecleaning.company.processes.CleanHouseProcess;
import dja.housecleaning.company.processes.ReceivePaymentProcess;

module dja.housecleaning.usecases {
	exports dja.housecleaning.usecases;

	requires transitive dja.housecleaning.company;
	requires joda.money;
	
	uses ReceivePaymentProcess;
	uses CleanHouseProcess;
}