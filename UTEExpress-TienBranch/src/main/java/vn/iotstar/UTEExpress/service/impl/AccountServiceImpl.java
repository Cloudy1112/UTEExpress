package vn.iotstar.UTEExpress.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iotstar.UTEExpress.entity.Account;
import vn.iotstar.UTEExpress.repository.IAccountRepository;
import vn.iotstar.UTEExpress.service.interfaces.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {
	@Autowired
	IAccountRepository accountRepository;
	public AccountServiceImpl(IAccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	@Override
	public long count() {
		return accountRepository.count();

	}

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();

	}

	@Override
	public <S extends Account> S save(S entity) {
		return accountRepository.save(entity);

	}

	@Override
	public Account findAccountByUserName(String username) {
		return accountRepository.findAccountByUserName(username);
		
	}
	
}
