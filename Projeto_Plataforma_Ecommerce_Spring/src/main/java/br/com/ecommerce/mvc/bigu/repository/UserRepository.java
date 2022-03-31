package br.com.ecommerce.mvc.bigu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ecommerce.mvc.bigu.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	 User findByUsername(String username);
	
}
