package vn.iotstar.UTEExpress.service.impl;

//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import vn.iotstar.UTEExpress.entity.Manager;
//import vn.iotstar.UTEExpress.repository.AdminRepository;
//import vn.iotstar.UTEExpress.service.interfaces.IAdminService;
//
//@Service
//public class AdminServiceImpl implements IAdminService{
//	@Autowired
//	private AdminRepository adminRepository;
//	
//	public AdminServiceImpl(AdminRepository adminRepository) {
//		this.adminRepository = adminRepository;
//	}
//
//	@Override
//	public <S extends Manager> S save(S entity) {
//		return adminRepository.save(entity);
//	}
//
//	@Override
//	public List<Manager> findAll() {
//		return adminRepository.findAll();
//	}
//
//	@Override
//	public Optional<Manager> findById(String id) {
//		return adminRepository.findById(id);
//	}
//
//	@Override
//	public long count() {
//		return adminRepository.count();
//	}
//
//	@Override
//	public void deleteById(String id) {
//		adminRepository.deleteById(id);
//	}
//
//	@Override
//	public void delete(Manager entity) {
//		adminRepository.delete(entity);
//	}
//	
//}
