package com.sxc.security.service.impl;

import com.sxc.testweb.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 一个自定义的service用来和数据库进行操作. 即以后我们要通过数据库保存权限.则需要我们继承UserDetailsService
 * 
 * @author Ming.Zi
 * 
 */
public class CustomUserDetailsService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

	
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {

		User user = new User();

		try {

			user.setId(1);
			user.setUsername("zhang3");
			user.setUsername("zhang3");
			user.setAge(23);

			List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
//			authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
			user.setAuthorities(authList);


		} catch (Exception e) {
			logger.error("Error in retrieving user", e);
			throw new UsernameNotFoundException("用户"+userName+"不存在!");
		}

		return user;
	}
}
