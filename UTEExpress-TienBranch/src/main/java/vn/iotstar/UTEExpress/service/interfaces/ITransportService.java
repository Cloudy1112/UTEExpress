package vn.iotstar.UTEExpress.service.interfaces;

import java.util.List;

import vn.iotstar.UTEExpress.entity.Transport;

public interface ITransportService {

	List<Transport> getAllTransports();

    Transport getTransportByType(String transportType);

    Transport getTransportById(Integer transportID);
	
}
