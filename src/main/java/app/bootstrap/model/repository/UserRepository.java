package app.bootstrap.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.bootstrap.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
	
}
