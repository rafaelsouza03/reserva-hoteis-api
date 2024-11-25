package br.com.hoteliza.reservation_api.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoomType {

	SINGLE("Quarto Single"),
	DOUBLE("Quarto de Casal"),
	TWIN("Quarto Twin"),
	DELUXE_DOUBLE("Quarto de Casal Deluxe"),
	APARTMENT("Apartamento"),
	JR_SUITE("Suíte Júnior"),
	EXEC_SUITE("Suíte Executiva"),
	PRES_SUITE("Suíte Presidencial");

	private final String description;

}
