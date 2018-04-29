import dja.housecleaning.company.internal.processes.uber.transport.UberTransportProcess;
import dja.housecleaning.company.processes.TransportProcess;

module dja.housecleaning.uber.transport {

	requires dja.housecleaning.company;
	requires things;

	provides TransportProcess with UberTransportProcess;

}