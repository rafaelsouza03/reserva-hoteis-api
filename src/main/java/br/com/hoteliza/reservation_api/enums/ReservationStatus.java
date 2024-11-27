package br.com.hoteliza.reservation_api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ReservationStatus {
	
	PENDING_CONFIRMATION("Confirmação pendente"),
	COMPLETE("Completa"),
	CLIENT_CANCELLED("Cancelado pelo cliente"),
	HOTEL_CANCELLED("Cancelado pelo hotel");

    private final String descricao;
    
}
