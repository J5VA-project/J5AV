package com.J5VA.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import com.J5VA.dao.customerDao;
import com.J5VA.entity.account;
import com.J5VA.entity.customer;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	customerDao customerDao;

	@Autowired
	BCryptPasswordEncoder pe;

	@Override
	public UserDetails loadUserByUsername(String username_custo) throws UsernameNotFoundException {
		try {
			customer account = customerDao.findById(username_custo).get();

			String password = account.getPassword();

			return User.withUsername(username_custo).password(pe.encode(password)).roles("").build();
		} catch (Exception e) {
			throw new UsernameNotFoundException(username_custo + " not found");
		}
	}

	public void loginFromOAuth2(OAuth2AuthenticationToken oauth2) {
		String email = oauth2.getPrincipal().getAttribute("email");
		String password = Long.toHexString(System.currentTimeMillis());

		UserDetails user = User.withUsername(email).password(pe.encode(password)).roles("GUEST").build();

		Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
	}
}
