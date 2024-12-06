package vn.iotstar.UTEExpress.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.iotstar.UTEExpress.entity.Voucher;

public interface VoucherRepository {
	Optional<Voucher> findByTransportType(String IdTransportType);
	Optional<Voucher> findByGoodsType(String IdGoodsType);
	Optional<Voucher> findByDayStart(Date dayStart);
	Optional<Voucher> findByDayEnd(Date dayEnd);
	
	Page<Voucher> getAllPost(String IdVoucher, Pageable pageable);
	
}
