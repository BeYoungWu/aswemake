package com.market.dto;

import javax.validation.constraints.NotBlank;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class AccountDto {
	
	@Getter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class SignupReqDto {
		@NotBlank
		private String userId;
		@NotBlank
		private String password;
		private boolean admin = false;
		private String adminToken = "";
	}
	
	@Getter
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class LoginReqDto {
		private String userId;
		private String password;
	}
}
