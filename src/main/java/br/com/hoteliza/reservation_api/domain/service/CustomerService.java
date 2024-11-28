package br.com.hoteliza.reservation_api.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.hoteliza.reservation_api.domain.model.Customer;
import br.com.hoteliza.reservation_api.domain.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerService {

	private CustomerRepository customerRepository;

	@Transactional
	public Customer register(final Customer customer) {
		return customerRepository.save(customer);
	}

	@Transactional
	public Customer update(final Customer customer, Long customerId) {
		Customer findCustomer = search(customerId);
		
		findCustomer.setName(customer.getName());
		findCustomer.setEmail(customer.getEmail());
		findCustomer.setPassword(customer.getPassword());
		findCustomer.setPhoneNumber(customer.getPhoneNumber());
		findCustomer.setProfilePicture(customer.getProfilePicture());
		
		return customerRepository.save(findCustomer);
	}
	
	@Transactional
	public Customer search(final Long customerId) {
		return customerRepository.findById(customerId).orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
	}
	
	@Transactional
	public List<Customer> list(){
		return customerRepository.findAll();
	}

}
