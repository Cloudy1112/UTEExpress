package vn.iotstar.UTEExpress.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.UTEExpress.entity.Account;
import vn.iotstar.UTEExpress.repository.IAccountRepository;
import vn.iotstar.UTEExpress.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService{
	@Autowired
	IAccountRepository accountRepository;

	public void delete(Account entity) {
		accountRepository.delete(entity);
	}

	public <S extends Account> S save(S entity) {
		return accountRepository.save(entity);
	}

	public Optional<Account> findById(String id) {
		return accountRepository.findById(id);
	}


	
	
}
