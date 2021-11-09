package com.J5VA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
import com.J5VA.dao.customerDao;
=======

import com.J5VA.dao.AccountDao;
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe
import com.J5VA.entity.*;
import com.J5VA.service.ParamService;


@Controller
@RequestMapping("/home/change-pw")
public class ChangePasswordController {
	@Autowired 
<<<<<<< HEAD
	customerDao dao;
=======
	AccountDao dao;
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe
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
<<<<<<< HEAD
			customer account = dao.findByUsername(username);
=======
			Account account = dao.findByUsername(username);
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe
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
