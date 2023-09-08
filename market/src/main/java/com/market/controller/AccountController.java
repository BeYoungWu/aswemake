package com.market.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.dto.AccountDto;
import com.market.dto.CommonResDto;
import com.market.serivce.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {
	
	private final AccountService accountService;
	
	@PostMapping("/register")
	public ResponseEntity<CommonResDto> registerProduct(@RequestBody AccountDto.AccountResDto account) {

		return ResponseEntity.ok().body(accountService.register(account));
	}
	
	@PostMapping("/login")
	public ResponseEntity<CommonResDto> registerProduct(@RequestBody AccountDto.AccountResDto account, HttpSession session) {
		AccountDto.AccountResDto exist = accountService.check(account);
		if (exist!=null) {
			session.setAttribute("loginuser", exist);
		}
		return ResponseEntity.ok().body(accountService.login(account));
		
	}

}
