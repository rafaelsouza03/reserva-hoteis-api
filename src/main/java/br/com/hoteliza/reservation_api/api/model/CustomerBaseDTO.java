package br.com.hoteliza.reservation_api.api.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerBaseDTO {

	@NotNull
	private Long id;
}
