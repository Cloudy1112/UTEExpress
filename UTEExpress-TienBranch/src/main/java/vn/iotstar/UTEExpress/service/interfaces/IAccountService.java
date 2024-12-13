package vn.iotstar.UTEExpress.service.interfaces;

import java.util.List;

import vn.iotstar.UTEExpress.entity.Account;

public interface IAccountService {
	long count();

	List<Account> findAll();

	<S extends Account> S save(S entity);

	Account findAccountByUserName(String username);
}
