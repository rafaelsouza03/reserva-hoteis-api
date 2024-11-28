package br.com.hoteliza.reservation_api.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hoteliza.reservation_api.api.model.user.customer.CustomerInputDTO;
import br.com.hoteliza.reservation_api.api.model.user.customer.CustomerOutputDTO;
import br.com.hoteliza.reservation_api.assembler.CustomerAssembler;
import br.com.hoteliza.reservation_api.domain.service.CustomerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

	private CustomerAssembler customerAssembler;
	private CustomerService customerService;

	@PutMapping("/{customerId}")
	public ResponseEntity<CustomerOutputDTO> update(@PathVariable final @NotNull Long customerId,
			@RequestBody @Valid final CustomerInputDTO customerInputDTO) {
		return ResponseEntity.ok(customerAssembler
				.toDto(customerService.update(customerAssembler.toCustomer(customerInputDTO), customerId)));
	}

	@GetMapping("/{customerId}")
	public CustomerOutputDTO consult(@PathVariable final @NotNull Long customerId) {
		return customerAssembler.toDto(customerService.search(customerId));
	}

}
