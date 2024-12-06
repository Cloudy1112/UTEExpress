package vn.iotstar.UTEExpress.service.interfaces;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vn.iotstar.UTEExpress.entity.Voucher;

public interface IVoucherService {
	Optional<Voucher> findById(String id);

	Optional<Voucher> findByName(String name);

	void deleteVoucher(String id);

	void addVoucher(Voucher voucher);

	void updateVoucher(String id, Voucher voucher);

	public Page<Voucher> getAllVoucher(String id, Pageable pageable);
	
	public Page<Voucher> getValidVoucher(String id, Date currentday, Pageable pageable);
	
	public Page<Voucher> getSuitableVoucher(String IdVoucher, String IdOrder, Pageable pageable);
	
	Long countVoucher();
}
