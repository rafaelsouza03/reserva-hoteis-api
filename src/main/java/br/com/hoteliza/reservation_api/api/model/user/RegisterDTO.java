package br.com.hoteliza.reservation_api.api.model.user;

import br.com.hoteliza.reservation_api.enums.UserRole;

public record RegisterDTO(String name, String email, String password, UserRole role) {
	
}
