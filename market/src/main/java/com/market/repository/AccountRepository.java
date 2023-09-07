package com.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.market.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	@Query("SELECT a FROM tbl_account a WHERE a.password=:password")
	Account findUser(@Param("password") String password);

	
	
}
