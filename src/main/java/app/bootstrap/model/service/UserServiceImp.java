package app.bootstrap.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import app.bootstrap.model.entity.User;
import app.bootstrap.model.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private BCryptPasswordEncoder bCrypt;
	
	private UserRepository repo;
	
	@Override
	public void save(User user) {
		user.setPassword(bCrypt.encode(user.getPassword()));
		repo.save(user);
	}

	
}
