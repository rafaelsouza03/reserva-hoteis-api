package br.com.hoteliza.reservation_api.api.model;

import java.util.List;

import br.com.hoteliza.reservation_api.domain.model.Facility;
import br.com.hoteliza.reservation_api.domain.model.HotelOwner;
import br.com.hoteliza.reservation_api.domain.model.Room;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelInputDTO {

	@NotBlank(message = "Digite o nome do hotel.")
	@Size(max = 64)
	private String name;
	
	@NotBlank(message = "Escolha as comodidades do hotel.")
	private List<Facility> facilities;
	
	@NotBlank(message = "Digite o endereço do hotel.")
	@Size(max = 255)
	private String address;
	
	@NotBlank(message = "Escolha as proximidades do hotel.")
	private List<String> vicinities;
	
	@NotBlank(message = "Digite as politicas do hotel.")
	@Size(max = 1024)
	private String policy;
	
	@NotNull
	private HotelOwner owner;
	
	@NotBlank(message = "Adicione quartos ao seu hotel")
	private List<Room> rooms;
	
}
