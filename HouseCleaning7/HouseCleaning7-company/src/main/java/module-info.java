import dja.housecleaning.company.internal.processes.InternalCleanHouseProcess;
import dja.housecleaning.company.internal.processes.InternalReceivePaymentProcess;
import dja.housecleaning.company.internal.processes.InternalTransportProcess;
import dja.housecleaning.company.processes.CleanHouseProcess;
import dja.housecleaning.company.processes.ReceivePaymentProcess;
import dja.housecleaning.company.processes.TransportProcess;

module dja.housecleaning.company {
	exports dja.housecleaning.company;
	exports dja.housecleaning.company.processes;

	requires joda.money;
	requires things;
	
	provides ReceivePaymentProcess with InternalReceivePaymentProcess;
	provides TransportProcess with InternalTransportProcess;
	provides CleanHouseProcess with InternalCleanHouseProcess;

	uses TransportProcess;
}