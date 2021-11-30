package com.J5VA.controller.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.J5VA.entity.Account;
import com.J5VA.service.AccountService;
import com.J5VA.util.DateFormatUtil;

@Controller
@RequestMapping("/home/profile")
public class ProfileController {
	@Autowired
	HttpServletRequest request;

	@Autowired
	AccountService service;

	@GetMapping()
	public String profile(Model model, DateFormatUtil format) {
		Account acc = service.findById(request.getRemoteUser());
		acc.setHire_date(format.convertToDateSQL(acc.getHire_date()));
		acc.setBirthdate(format.convertToDateSQL(acc.getBirthdate()));

		model.addAttribute("acc", acc);
		return "user/body/profile";
	}

	@PostMapping("/update")
	public String profileUpdate(Model model, DateFormatUtil format) {
		Account account = new Account();
		account.setUsername(request.getParameter("username"));
		account.setFullname(request.getParameter("fullname"));
		account.setEmail(request.getParameter("email"));
		account.setAddress(request.getParameter("address"));
		account.setPhone(request.getParameter("phone"));
		account.setBirthdate(format.toDate(request.getParameter("birthdate"), "yyyy-MM-dd"));
		account.setPassword(request.getParameter("password"));
		account.setHire_date(format.toDate(request.getParameter("hire_date"), "yyyy-MM-dd"));
		Double salDouble = Double.parseDouble(request.getParameter("salary"));
		account.setSalary(salDouble);
		service.update(account);
		return "redirect:/home/profile";
	}

}
