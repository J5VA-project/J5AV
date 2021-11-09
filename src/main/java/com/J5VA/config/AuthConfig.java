package com.J5VA.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.J5VA.service.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class AuthConfig extends WebSecurityConfigurerAdapter {
	@org.springframework.beans.factory.annotation.Autowired(required = true)
	UserService userService;

	/*-- ma hoa mat khau*/
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*--Quan ly du lieu nguoi su dung--*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}

	/* Phan quyen su dung va hinh thuc dang nhap */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// CSRF, CORS
		http.csrf().disable().cors().disable();
<<<<<<< HEAD

		// phan quyen su dung
//		http.authorizeRequests().antMatchers("/home/shop", "/rest/authorities/**").hasAnyRole("1")
//				.anyRequest().permitAll();
		http.httpBasic();
=======
		http.authorizeRequests()
				.antMatchers("/home/checkout", "/home/order/listorder", "/home/change-pw", "/home/forgot-pw",
						"/home/order-detail/**", "/rest/authorities/**")
				.authenticated().anyRequest().permitAll();
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe

		// dieu khien loi truy cap khong dung vai tro
		http.exceptionHandling().accessDeniedPage("/auth/access/denied");

		http.formLogin().loginPage("/auth/login/form").loginProcessingUrl("/auth/login")
				.defaultSuccessUrl("/auth/login/success", false).failureUrl("/auth/login/error")
<<<<<<< HEAD
				.usernameParameter("username_custo").passwordParameter("password");
=======
				.usernameParameter("username").passwordParameter("password");
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe

		// dang xuat
		http.logout().logoutUrl("/auth/logoff").logoutSuccessUrl("/auth/logoff/success");

		// OAuth2 - Đăng nhập từ mạng xã hội
		http.oauth2Login().loginPage("/auth/login/form").defaultSuccessUrl("/oauth2/login/success", true)
				.failureUrl("/auth/login/error").authorizationEndpoint().baseUri("/oauth2/authorization");
	}
}
