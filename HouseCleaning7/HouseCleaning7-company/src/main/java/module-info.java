import dja.housecleaning.company.internal.processes.InternalCleanHouseProcess;
import dja.housecleaning.company.internal.processes.InternalNewOrderProcess;
import dja.housecleaning.company.internal.processes.InternalPrepareForCleaningProcess;
import dja.housecleaning.company.internal.processes.InternalTransportProcess;
import dja.housecleaning.company.processes.CleanHouseProcess;
import dja.housecleaning.company.processes.NewOrderProcess;
import dja.housecleaning.company.processes.PrepareForCleaningProcess;
import dja.housecleaning.company.processes.TransportProcess;

module dja.housecleaning.company {
	exports dja.housecleaning.company.processes;
	exports dja.housecleaning.company.jobpositions;

	requires joda.money;
	requires things;
	
	provides NewOrderProcess with InternalNewOrderProcess;
	provides TransportProcess with InternalTransportProcess;
	provides CleanHouseProcess with InternalCleanHouseProcess;
	provides PrepareForCleaningProcess with InternalPrepareForCleaningProcess;

}