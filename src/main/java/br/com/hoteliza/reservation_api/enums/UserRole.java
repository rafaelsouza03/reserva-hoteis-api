package br.com.hoteliza.reservation_api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRole {

	CUSTOMER("Cliente"),
	OWNER("Proprietário");

	private final String description;

}