package br.com.hoteliza.reservation_api.domain.service;

import org.springframework.stereotype.Service;

import br.com.hoteliza.reservation_api.domain.model.Customer;
import br.com.hoteliza.reservation_api.domain.model.User;
import br.com.hoteliza.reservation_api.domain.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerService {

	private UserRepository userRepository;

	@Transactional
	public Customer update(final Customer customer, Long customerId) {
		Customer findCustomer = search(customerId);

		findCustomer.setName(customer.getName());
		findCustomer.setEmail(customer.getEmail());
		findCustomer.setPassword(customer.getPassword());
		findCustomer.setPhoneNumber(customer.getPhoneNumber());

		return userRepository.save(findCustomer);
	}

	@Transactional
	public Customer search(final Long customerId) {
		User user = userRepository.findById(customerId)
				.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));

		if (user instanceof Customer) {
			return (Customer) user;
		} else {
			throw new EntityNotFoundException("O usuário encontrado não é um cliente");
		}
	}

}
