package com.J5VA.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.J5VA.dao.AccountDao;
import com.J5VA.entity.Account;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AccountDao accDao;

	@RequestMapping("/index")
	public String index(Model model, HttpServletRequest request) {
		Account acc = accDao.findByUsername(request.getRemoteUser());
		model.addAttribute("acc", acc == null ? "" : acc);
		return "admin/index.html";
	}

	@RequestMapping("/home")
	public String home() {
		return "admin/home/home.html";
	}

	@RequestMapping("/logout")
	public String logout() {
		return "admin/account/page-login.html";
	}

	@RequestMapping("/login/index")
	public String form(Model model) {
		Account acc = new Account();
		model.addAttribute("acc", acc);
		return "admin/account/page-login.html";
	}

	@RequestMapping("/change-pw")
	public String change_pw() {
		return "admin/account/change-pw.html";
	}

	@RequestMapping("/reset-pw")
	public String reset_pw() {
		return "admin/account/reset-pw.html";
	}

	@RequestMapping("/authorized")
	public String authorized() {
		return "admin/account/authorized.html";
	}

	@RequestMapping("/account-form")
	public String account_form() {
		return "admin/account/account-form.html";
	}

	@RequestMapping("/account-list")
	public String account_list() {
		return "admin/account/account-list.html";
	}

	@RequestMapping("/account-authorize")
	public String account_authorize() {
		return "";
	}

	@RequestMapping("/order")
	public String order() {
		return "admin/order/order.html";
	}

	@RequestMapping("/product-form")
	public String product_form() {
		return "admin/product/product-form.html";
	}

	@RequestMapping("/products-list")
	public String products_list() {
		return "admin/product/products-list.html";
	}

	@RequestMapping("/size-manager")
	public String size_manager() {
		return "admin/product/size-manager.html";
	}

	@RequestMapping("/report")
	public String report() {
		return "admin/report/report.html";
	}

	@RequestMapping("/category-manager")
	public String category_manager() {
		return "admin/product/category-manager.html";
	}

}
