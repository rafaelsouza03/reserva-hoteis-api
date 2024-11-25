package br.com.hoteliza.reservation_api.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.hoteliza.reservation_api.api.model.CustomerInputDTO;
import br.com.hoteliza.reservation_api.api.model.CustomerOutputDTO;
import br.com.hoteliza.reservation_api.assembler.CustomerAssembler;
import br.com.hoteliza.reservation_api.domain.service.CustomerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

	private CustomerAssembler customerAssembler;
	private CustomerService customerService;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerOutputDTO getMethodName(@RequestBody final @Valid CustomerInputDTO customerInputDTO) {
		return customerAssembler.toDto(customerService.register(customerAssembler.toCustomer(customerInputDTO)));
	}

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

	@GetMapping("/list")
	public List<CustomerOutputDTO> list() {
		return customerAssembler.toCollectionDto(customerService.list());
	}

}
