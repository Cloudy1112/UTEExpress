package vn.iotstar.UTEExpress.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.UTEExpress.entity.Transport;
import vn.iotstar.UTEExpress.repository.ITransportRepository;
import vn.iotstar.UTEExpress.service.interfaces.ITransportService;
@Service
public class TransportServiceImpl implements ITransportService {
	@Autowired
    ITransportRepository transportRepository;

	@Override
	public List<Transport> getAllTransports() {
        return transportRepository.findAll();

	}

	@Override
	public Transport getTransportByType(String transportType) {
        return transportRepository.findByTransportType(transportType);

	}

	@Override
	public Transport getTransportById(Integer transportID) {
        return transportRepository.findById(transportID).orElse(null);

	}

	

}
