package com.J5VA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.J5VA.dao.customerDao;
import com.J5VA.entity.*;
import com.J5VA.service.ParamService;


@Controller
@RequestMapping("/account/change-pwd")
public class ChangePasswordController {
	@Autowired 
	customerDao dao;
	@Autowired
	ParamService paramService;
	@GetMapping
	public String getPage(Model model) {
		return "home/change-pwd";
	}
	@PostMapping
	public String changePass(Model model) {
		String username = paramService.getString("username", "");
		String password = paramService.getString("password", "");
		String newPass = paramService.getString("newpassword", "");
		String cfpw = paramService.getString("confirmpassword", "");	
		try {
			customer account = dao.findByUsername(username);
		if (account.getPassword().equals(password)) {
			if (newPass.equals(cfpw)) {
				account.setPassword(newPass);
				dao.save(account);
				model.addAttribute("message", "Change password succsess!");
			} else {
				model.addAttribute("message", "Confirm password doesn't match!");
			}
		} else {
			model.addAttribute("message", "Password invalid!");			
		}
		} catch (Exception e) {
			model.addAttribute("message", "Username invalid!");
		}		
		return "home/change-pwd"; 
	}
	
}
