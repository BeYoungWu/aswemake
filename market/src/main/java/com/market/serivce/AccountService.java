package com.market.serivce;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.market.domain.Account;
import com.market.dto.AccountDto;
import com.market.dto.AccountDto.AccountResDto;
import com.market.dto.CommonResDto;
import com.market.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

	private final AccountRepository accountRepository;

	@Transactional
	public AccountDto.AccountResDto check(AccountResDto account) {
		Account check = accountRepository.findUser(account.getPassword());
		AccountDto.AccountResDto accountDto = AccountDto.AccountResDto.builder()
				.accountNo(check.getAccountNo())
				.password(check.getPassword())
				.build();
		return accountDto;
	}
	
	@Transactional
	public CommonResDto login(AccountDto.AccountResDto account) {
		Account exist = accountRepository.findUser(account.getPassword());
		if (exist!=null) {
			return CommonResDto.builder().message("관리자 로그인 되었습니다.").build();
		} else {
			return CommonResDto.builder().message("로그인에 실패했습니다.").build();
		}
	}

	

	
	
	
}
