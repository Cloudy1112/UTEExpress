package vn.iotstar.UTEExpress.service;

import java.util.Optional;

import vn.iotstar.UTEExpress.entity.Shipper;

public interface IShipperService {

	Optional<Shipper> findByShipperID(Integer shipperID);
}
