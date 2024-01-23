package com.medicare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.bean.Account;
import com.medicare.bean.Addtocart;
import com.medicare.service.AccountService;

@RestController
@RequestMapping("login")
@CrossOrigin
public class AccountController {
	@Autowired
	AccountService accountservice;
	
	@PostMapping(value="signUp",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String signUp(@RequestBody Account account) {
		return accountservice.signUp(account);
	}
	
	@PostMapping(value = "signIn", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signIn(@RequestBody Account acc) {
		return accountservice.Login(acc);
		
	}
	@PatchMapping(value="updatepswd",consumes=MediaType.APPLICATION_JSON_VALUE)
	public Account updatepassword(@RequestBody Account account) {
		return accountservice.updatePassword(account);
	}
	@PatchMapping(value="updateProfile",consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateProfile(@RequestBody Account account) {
		return accountservice.updateProfile(account);
	}
	
	@GetMapping(value="profile/{email}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Account orderSummaryByEmail(@PathVariable("email") String email) {
		return accountservice.viewPro(email);
	}
    

}
