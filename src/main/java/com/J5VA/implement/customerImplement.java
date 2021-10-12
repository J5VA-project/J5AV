package com.J5VA.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import com.J5VA.dao.customerDao;
import com.J5VA.entity.customer;
import com.J5VA.service.customerService;

@Service
public class customerImplement implements customerService {
	@Autowired
	customerDao dao;

	@Autowired
	BCryptPasswordEncoder pe;

	@Override
	public customer findById(String username_custo) {
		// TODO Auto-generated method stub
		return dao.findById(username_custo).get();
	}

	@Override
	public List<customer> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public customer create(customer custo) {
		// TODO Auto-generated method stub
		return dao.save(custo);
	}

	@Override
	public customer update(customer custo) {
		// TODO Auto-generated method stub
		return dao.save(custo);
	}

	@Override
	public void delete(String username_custo) {
		// TODO Auto-generated method stub
		dao.deleteById(username_custo);
	}

	public void loginFromOAuth2(OAuth2AuthenticationToken oauth2) {
		String email = oauth2.getPrincipal().getAttribute("email");
		String password = Long.toHexString(System.currentTimeMillis());

//		UserDetails user = User.withUsername(email).password(pe.encode(password)).roles("GUEST").build();
//
//		Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//		SecurityContextHolder.getContext().setAuthentication(auth);
	}

}
