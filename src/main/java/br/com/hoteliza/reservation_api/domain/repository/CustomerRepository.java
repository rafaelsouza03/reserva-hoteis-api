package br.com.hoteliza.reservation_api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hoteliza.reservation_api.domain.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
