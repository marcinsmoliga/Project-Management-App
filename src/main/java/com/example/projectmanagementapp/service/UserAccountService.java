package com.example.projectmanagementapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectmanagementapp.dao.UserAccountRepository;
import com.example.projectmanagementapp.entity.UserAccount;

@Service
public class UserAccountService {
	private final UserAccountRepository  userAccountRepository;

	@Autowired
	UserAccountService(UserAccountRepository userAccountRepository) {
		this.userAccountRepository = userAccountRepository;
	}

	public UserAccount save(UserAccount userAccount) {
		return userAccountRepository.save(userAccount);
	}
}
