package vn.iotstar.UTEExpress.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import vn.iotstar.UTEExpress.entity.StatusOrder;
import vn.iotstar.UTEExpress.repository.IStatusOrderRepository;
import vn.iotstar.UTEExpress.service.interfaces.IOrderStatusService;

public class OrderStatusImpl implements IOrderStatusService {
	@Autowired
	private IStatusOrderRepository statusOrderRepository;
	@Override
	public List<StatusOrder> findAll() {
		return statusOrderRepository.findAll();	}

	@Override
	public Optional<StatusOrder> findById(Integer idStatusOrder) {
		return statusOrderRepository.findById(idStatusOrder);
	}

	@Override
	public StatusOrder save(StatusOrder statusOrder) {
		return statusOrderRepository.save(statusOrder);
	}

	@Override
	public void deleteById(Integer idStatusOrder) {
		 statusOrderRepository.deleteById(idStatusOrder);
		
	}

}
