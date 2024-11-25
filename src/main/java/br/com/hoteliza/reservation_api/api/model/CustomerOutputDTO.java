package br.com.hoteliza.reservation_api.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerOutputDTO extends CustomerBaseDTO{

	private String name;
	
	private String email;

}
