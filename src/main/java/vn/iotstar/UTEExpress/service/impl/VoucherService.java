package vn.iotstar.UTEExpress.service.impl;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.iotstar.UTEExpress.entity.Voucher;
import vn.iotstar.UTEExpress.repository.VoucherRepository;
import vn.iotstar.UTEExpress.service.interfaces.IVoucherService;

@Service
public class VoucherService implements IVoucherService{

	@Autowired
	VoucherRepository voucherRepository;
	
	@Override
	public Optional<Voucher> findById(String id) {
		// TODO Auto-generated method stub
		return voucherRepository.findById(id);
	}

	@Override
	public Optional<Voucher> findByName(String name) {
		// TODO Auto-generated method stub
		return voucherRepository.findByVouchername(name);
	}

	@Override
	public void deleteVoucher(String id) {
		voucherRepository.deleteById(id);
	}


//	@Override
//	public Page<Voucher> getAllVoucher(Pageable pageable) {  
//		/// Này sẽ lấy toàn bộ Voucher (kể cả hết hạn)
//		//Dùng cho ADMIN, Manager
//		return voucherRepository.findAll(pageable);
//	}
	
	@Override
	public Page<Voucher> getValidVoucher(String id, Date currentday, Pageable pageable) { 
		///Này sẽ trả về Voucher có thể dùng được (trong khoảng ngày valid)
		//Dùng cho ADMIN, Manager
		return voucherRepository.getValidVouchersByDate(id,currentday,pageable);
	}


	@Override
	public Page<Voucher> getSuitableVoucher(String IdVoucher, String IdOrder, Pageable pageable) {
		///Này sẽ trả về Voucher có thể dùng được (trong khoảng ngày valid, lọc theo goods và transport)
		//Dùng cho User
		return voucherRepository.getSuitableVoucher(IdVoucher, IdOrder, pageable) ;
	}


	@Override
	public Long countVoucher() {
		// TODO Auto-generated method stub
		return voucherRepository.count();
	}

	@Override
	public void updateVoucher(String id, Voucher voucher) {
		Voucher voucherBefore = voucherRepository.findById(id).orElseThrow();
		
		voucherBefore.setAmount(voucher.getAmount());
		voucherBefore.setDayEnd(voucher.getDayEnd());
		voucherBefore.setDayStart(voucher.getDayStart());
		voucherBefore.setVouchername(voucher.getVouchername());
		voucherBefore.setDescription(voucher.getDescription());
		voucherBefore.setGoods(voucher.getGoods());
		voucherBefore.setTransport(voucher.getTransport());
		
		voucherRepository.save(voucherBefore);
		
	}

	@Override
	public void addVoucher(Voucher voucher) {
		voucherRepository.save(voucher);
		
	}

	@Override
	public Page<Voucher> getAllVoucher(String id, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Page<Voucher> getAllVoucher(String id, Pageable pageable) {
//		// TODO Auto-generated method stub
//		return null;
//	}


}
