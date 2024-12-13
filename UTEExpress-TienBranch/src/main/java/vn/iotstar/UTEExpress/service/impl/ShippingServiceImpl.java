package vn.iotstar.UTEExpress.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.UTEExpress.entity.Account;
import vn.iotstar.UTEExpress.entity.Shipping;
import vn.iotstar.UTEExpress.repository.IShippingRepository;
import vn.iotstar.UTEExpress.service.interfaces.IAccountService;
import vn.iotstar.UTEExpress.service.interfaces.IShippingService;

@Service
public class ShippingServiceImpl implements IShippingService {
	@Autowired
	private IShippingRepository shippingRepository;

	@Override
	public Optional<Shipping> findByOrderId(String orderId) {
		 return shippingRepository.findById(orderId);
	}

	@Override
	public List<Shipping> findAll() {
        return shippingRepository.findAll();

	}

	@Override
	public Shipping save(Shipping shipping) {
		 shipping.setTotal(calculateTotalShipping(shipping));
	        return shippingRepository.save(shipping);
	}

	@Override
	public void deleteById(String orderId) {
		 shippingRepository.deleteById(orderId);
	}

	@Override
	public Integer calculateTotalShipping(Shipping shipping) {
		return null;
		
	}
	

	@Override
	public Shipping updateStatus(String orderId, Integer statusOrderId) {
		Optional<Shipping> optionalShipping = findByOrderId(orderId);
        if (optionalShipping.isPresent()) {
            Shipping shipping = optionalShipping.get();
            shipping.setStatusOrderID(statusOrderId);
            return shippingRepository.save(shipping);
        } else {
            return null;
        }
    }
	}

	
	

