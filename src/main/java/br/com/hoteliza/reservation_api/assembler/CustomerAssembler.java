package br.com.hoteliza.reservation_api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.hoteliza.reservation_api.api.model.user.customer.CustomerInputDTO;
import br.com.hoteliza.reservation_api.api.model.user.customer.CustomerOutputDTO;
import br.com.hoteliza.reservation_api.domain.model.Customer;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CustomerAssembler {

	private ModelMapper modelMapper;
	
	public Customer toCustomer(final CustomerInputDTO customerInputDTO) {
		return modelMapper.map(customerInputDTO, Customer.class);
	}
	
	public CustomerOutputDTO toDto(final Customer customer) {
		return modelMapper.map(customer, CustomerOutputDTO.class);
	}
	
	public List<CustomerOutputDTO> toCollectionDto(final List<Customer> customers){
		return customers.stream().map(this::toDto).collect(Collectors.toList());
	}
	
}
