package br.com.hoteliza.reservation_api.api.model.user;

import br.com.hoteliza.reservation_api.domain.model.UserRole;

public record RegisterDTO(String name, String email, String password, UserRole role) {
	
}
