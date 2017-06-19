package app.bootstrap.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.bootstrap.model.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
