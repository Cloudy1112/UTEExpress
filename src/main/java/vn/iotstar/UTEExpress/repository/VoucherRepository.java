package vn.iotstar.UTEExpress.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import vn.iotstar.UTEExpress.entity.Voucher;

public interface VoucherRepository extends JpaRepository<Voucher, String> {
	Optional<Voucher> findByTransportType(String IdTransportType);
	Optional<Voucher> findByGoodsType(String IdGoodsType);
	Optional<Voucher> findByDayStart(Date dayStart);
	Optional<Voucher> findByDayEnd(Date dayEnd);
	Optional<Voucher> findByName(String namevoucher);
	
	Page<Voucher> getAllVoucher(String IdVoucher, Pageable pageable);
	
	@Query("SELECT v FROM Voucher v WHERE v.dayStart <= :currentDate AND v.dayEnd >= :currentDate")
	Page<Voucher> getValidVouchersByDate(String id, Date currentDate, Pageable pageable);
	
	@NativeQuery("select idvoucher, amount, day_end, day_start, description, vouchername, idgoods, idmanager, idtransport "
			+ "from voucher v, orders o"
			+ "where o.orderdate between v.day_start and v.day_end"
			+ "and o.idtransport == v.idtransport"
			+ "and o.idgoods == v.idgoods")
	Page<Voucher> getSuitableVoucher(String IdVoucher, String IdOrder, Pageable pageable);
	
}
