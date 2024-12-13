package vn.iotstar.UTEExpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.iotstar.UTEExpress.entity.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, String> {
	@Query("SELECT a FROM Account a WHERE a.username = :username")
	 Account findAccountByUserName(@Param("username") String username);
}
