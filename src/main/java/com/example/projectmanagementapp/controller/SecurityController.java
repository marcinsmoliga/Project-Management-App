package com.example.projectmanagementapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.projectmanagementapp.entity.UserAccount;
import com.example.projectmanagementapp.service.UserAccountService;

@Controller
public class SecurityController {
	private final UserAccountService userAccountService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	SecurityController(UserAccountService userAccountService,
	                   BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userAccountService = userAccountService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@GetMapping("/register")
	public String register(Model model) {
		UserAccount userAccount = new UserAccount();
		model.addAttribute("userAccount", userAccount);
		return "security/register";
	}

	@PostMapping("/register/save")
	public String saveUserAccount(Model model, UserAccount userAccount) {
		userAccount.setPassword(bCryptPasswordEncoder.encode(userAccount.getPassword()));
		userAccountService.save(userAccount);
		return "redirect:/";
	}
}
