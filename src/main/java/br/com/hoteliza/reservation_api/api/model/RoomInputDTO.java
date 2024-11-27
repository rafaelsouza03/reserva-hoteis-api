package br.com.hoteliza.reservation_api.api.model;

import br.com.hoteliza.reservation_api.domain.model.Hotel;
import br.com.hoteliza.reservation_api.enums.RoomType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomInputDTO {

	@NotBlank(message = "Escolha o tipo de quarto.")
	private RoomType type;
	
	@NotBlank(message = "Digite a quantidade de camas.")
	private Integer bedAmount;
	
	@NotBlank(message = "Digite o preço da diária.")
	private Double pricePerDay;
	
	@NotBlank(message = "Escolha em qual hotel está o quarto.")
	private Hotel hotel;
	
}
