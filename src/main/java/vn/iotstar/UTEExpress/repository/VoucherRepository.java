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
    
    // Find voucher by transport ID (correct method name)
    Optional<Voucher> findByTransport_IDTransport(String IdTransport);
    
    // Find voucher by goods ID (correct method name)
    Optional<Voucher> findByGoods_IDGoods(String IdGoods);
    
    // Find voucher by start date
    Optional<Voucher> findByDayStart(Date dayStart);
    
    // Find voucher by end date
    Optional<Voucher> findByDayEnd(Date dayEnd);
    
    // Find voucher by voucher name
    Optional<Voucher> findByVouchername(String namevoucher);
    
    // Find voucher by voucher ID (correct method name)
    Page<Voucher> findByIDVoucher(String IDVoucher, Pageable pageable);

    
    // Query to get valid vouchers by current date
    @Query("SELECT v FROM Voucher v WHERE v.dayStart <= :currentDate AND v.dayEnd >= :currentDate")
    Page<Voucher> getValidVouchersByDate(String id, Date currentDate, Pageable pageable);
    
    // Native query to get suitable vouchers based on order date, transport, and goods
    @NativeQuery("SELECT v.* FROM vouchers v "
            + "JOIN orders o ON o.idtransport = v.idtransport AND o.idgoods = v.idgoods "
            + "WHERE o.orderdate BETWEEN v.day_start AND v.day_end")
    Page<Voucher> getSuitableVoucher(String IdVoucher, String IdOrder, Pageable pageable);
}
