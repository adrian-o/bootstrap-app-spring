package app.bootstrap.model.service.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import app.bootstrap.model.entity.Role;
import app.bootstrap.model.entity.User;
import app.bootstrap.model.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(arg0);
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		
		for (Role role : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return new UserSystem(user.getEmail(), user.getPassword(), grantedAuthorities);
	}

}
