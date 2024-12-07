package vn.iotstar.UTEExpress.service.interfaces;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vn.iotstar.UTEExpress.entity.Voucher;

public interface IVoucherService {
	Optional<Voucher> findById(String id);

	Optional<Voucher> findByName(String name);
	
	// Tìm Voucher có ngày bắt đầu trong khoảng
    List<Voucher> findByDayStartBetween(Date startDate, Date endDate);

	void deleteVoucher(String id);

	void addVoucher(Voucher voucher); //Thêm một voucher hoàn toàn mới
	
	void reduceVoucher(Voucher voucher); //Giảm số lượng của voucher (Giảm 1)
	
	void increaseVoucher(Voucher voucher); //Tăng số lượng voucher (tăng 1)

	void updateVoucher(String id, Voucher voucher);

	public Page<Voucher> getAllVoucher(String id, Pageable pageable);
	
	public Page<Voucher> getValidVoucher(String id, Date currentday, Pageable pageable);
	
	public Page<Voucher> getSuitableVoucher(String IdVoucher, String IdOrder, Pageable pageable);
	
	List<Voucher> findAll();
	
	Long countVoucher();
}
