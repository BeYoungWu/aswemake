package com.market.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.market.dto.AccountDto;
import com.market.serivce.AccountService;

@SpringBootTest
@Transactional
public class AccountControllerTest {

	@Autowired
	private AccountService accountService;
	
	@DisplayName("관리자 등록 테스트")
	@Test
	@Rollback(false)
	void 관리자_등록_테스트() {
		AccountDto.AccountResDto testuser = AccountDto.AccountResDto.builder()
				.password("test")
				.build();
		accountService.register(testuser);
	}
	
	@DisplayName("로그인 테스트")
	@Test
	void 로그인_테스트() {
		AccountDto.AccountResDto testuser = AccountDto.AccountResDto.builder()
				.password("test")
				.build();
		accountService.login(testuser);
	}
	
}
