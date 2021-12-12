package com.J5VA.config;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.J5VA.service.AccountService;
import com.J5VA.service.UserService;

import com.J5VA.entity.Account;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AuthConfig extends WebSecurityConfigurerAdapter {
	@Autowired(required = true)
	UserService userService;
	@Autowired
	AccountService accountService;
	@Autowired
	BCryptPasswordEncoder pe;

	/*-- ma hoa mat khau*/
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// cung cap nguon du lieu dang nhap
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(username -> {
			try {
				Account user = accountService.findById(username);
				String password = pe.encode(user.getPassword());
				String[] roles = user.getAuthorities().stream().map(er -> er.getRole().getRole_name())
						.collect(Collectors.toList()).toArray(new String[0]);
				return User.withUsername(username).password(password).roles(roles).build();
			} catch (NoSuchElementException e) {
				throw new UsernameNotFoundException(username + "not found");
			}
		});
	}

	/* Phan quyen su dung va hinh thuc dang nhap */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// CSRF, CORS
		http.csrf().disable().cors().disable();
		http.authorizeRequests()
				.antMatchers("/home/checkout", "/home/order/listorder", "/home/change-pw", 
						"/home/order-detail/**", "/rest/authorities/**","/home/favorite/list","/home/profile","/home/comment")
				.authenticated().antMatchers("/admin/index/**").hasRole("Manager")
				.anyRequest().permitAll();

		// dieu khien loi truy cap khong dung vai tro
		http.exceptionHandling().accessDeniedPage("/auth/access/denied");

		http.formLogin().loginPage("/auth/login/form").loginProcessingUrl("/auth/login")
				.defaultSuccessUrl("/auth/login/success", false).failureUrl("/auth/login/error")
				.usernameParameter("username").passwordParameter("password");

		// dang xuat
		http.logout().logoutUrl("/auth/logoff").logoutSuccessUrl("/auth/logoff/success");

		// OAuth2 - Đăng nhập từ mạng xã hội
		http.oauth2Login().loginPage("/auth/login/form").defaultSuccessUrl("/oauth2/login/success", true)
				.failureUrl("/auth/login/error").authorizationEndpoint().baseUri("/oauth2/authorization");
	}
}
