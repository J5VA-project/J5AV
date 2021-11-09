package com.J5VA.service;

<<<<<<< HEAD
import java.util.stream.Collectors;

=======
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe
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

<<<<<<< HEAD
import com.J5VA.dao.customerDao;
import com.J5VA.entity.account;
import com.J5VA.entity.customer;
=======
import com.J5VA.dao.AccountDao;
import com.J5VA.entity.Account;
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe

@Service
public class UserService implements UserDetailsService {
	@Autowired
<<<<<<< HEAD
	customerDao customerDao;
=======
	AccountDao dao;
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe

	@Autowired
	BCryptPasswordEncoder pe;

	@Override
<<<<<<< HEAD
	public UserDetails loadUserByUsername(String username_custo) throws UsernameNotFoundException {
		try {
			customer account = customerDao.findById(username_custo).get();

			String password = account.getPassword();

			return User.withUsername(username_custo).password(pe.encode(password)).roles("").build();
		} catch (Exception e) {
			throw new UsernameNotFoundException(username_custo + " not found");
=======
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Account account = dao.findById(username).get();

			String password = account.getPassword();

			return User.withUsername(username).password(pe.encode(password)).roles("").build();
		} catch (Exception e) {
			throw new UsernameNotFoundException(username + " not found");
>>>>>>> 143e3ba5cc786c2a4c3b8749a641044e07c913fe
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
