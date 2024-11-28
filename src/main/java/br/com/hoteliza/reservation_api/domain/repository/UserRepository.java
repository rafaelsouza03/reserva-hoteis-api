package br.com.hoteliza.reservation_api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.com.hoteliza.reservation_api.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	UserDetails findByEmail(String email);
	
}
