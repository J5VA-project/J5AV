package com.J5VA.service;

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

import com.J5VA.dao.accountDao;
import com.J5VA.entity.account;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	accountDao dao;

	@Autowired
	BCryptPasswordEncoder pe;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			account account = dao.findById(username).get();

			String password = account.getPassword();

			return User.withUsername(username).password(pe.encode(password)).roles("").build();
		} catch (Exception e) {
			throw new UsernameNotFoundException(username + " not found");
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
