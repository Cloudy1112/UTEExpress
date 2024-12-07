package vn.iotstar.UTEExpress.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.iotstar.UTEExpress.entity.Voucher;

public interface VoucherRepository extends JpaRepository<Voucher, String> {
    Optional<Voucher> findByTransportType(String type);
    Optional<Voucher> findByGoodsType(String type);
	Optional<Voucher> findByDayStart(Date dayStart);
	Optional<Voucher> findByDayEnd(Date dayEnd);
	Optional<Voucher> findByVouchername(String vouchername);
	
//	Page<Voucher> getAllVoucher(String IdVoucher, Pageable pageable);
	Page<Voucher> findAll(Pageable pageable);
	
	@Query("SELECT v FROM Voucher v WHERE v.dayStart <= :currentDate AND v.dayEnd >= :currentDate")
	Page<Voucher> getValidVouchersByDate(String id, Date currentDate, Pageable pageable);
	
	@NativeQuery("SELECT v.idvoucher, v.amount, v.day_end, v.day_start, v.description, v.vouchername, v.idgoods, v.idmanager, v.idtransport "
	        + "FROM voucher v "
	        + "JOIN orders o ON o.idtransport = v.idtransport AND o.idgoods = v.idgoods "
	        + "WHERE o.orderdate BETWEEN v.day_start AND v.day_end")
	Page<Voucher> getSuitableVoucher(String IdVoucher, String IdOrder, Pageable pageable);
	
}
