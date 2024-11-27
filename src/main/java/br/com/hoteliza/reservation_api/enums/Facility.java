package br.com.hoteliza.reservation_api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Facility {
	
	GYM("Academia"),
	POOL("Piscina"),
	PRIVATE_PARKING("Estacionamento privativo"),
	TOILETRIES("Artigos de higiene Pessoal"),
	WIFI("Wi-Fi grátis"),
	BREAKFEST("Café da manhã"),
	LIBRARY("Biblioteca"),
	BAR("Bar"),
	SPA("Spa"),
	MULTI_COURT("Quadra poliesportiva"),
	PLAYGROUND("Parque infantil"),
	ATM("Caixa 24h"),
	FUMOIR("Fumódromo");

	private String description;
	
}
