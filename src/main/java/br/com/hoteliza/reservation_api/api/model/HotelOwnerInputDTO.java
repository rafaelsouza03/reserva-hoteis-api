package br.com.hoteliza.reservation_api.api.model;

import java.util.List;

import br.com.hoteliza.reservation_api.domain.model.Hotel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelOwnerInputDTO {

	@NotBlank(message = "Digite seu nome.")
	@Size(max = 64)
	private String name;

	@NotBlank(message = "Digite seu E-mail.")
	@Email(message = "O E-mail deve ser válido.")
	private String email;

	@NotBlank(message = "Digite sua senha.")
	@Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres.")
	private String password;

	private List<Hotel> hotels;

}
