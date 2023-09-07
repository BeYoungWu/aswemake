package com.market.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.market.dto.AccountDto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountNo;
	
	@Column(nullable = false)
	private String password;
	
	@Builder
	public Account(int accountNo, String password) {
		this.accountNo = accountNo;
		this.password = password;
	}
	
	public static Account DtoToAccount(AccountDto.AccountResDto account) {
		return builder()
			.password(account.getPassword())
			.build();
	}
	
}
