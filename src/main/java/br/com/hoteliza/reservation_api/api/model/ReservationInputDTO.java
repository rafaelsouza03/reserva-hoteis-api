package br.com.hoteliza.reservation_api.api.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.hoteliza.reservation_api.domain.model.Customer;
import br.com.hoteliza.reservation_api.domain.model.ReservationStatus;
import br.com.hoteliza.reservation_api.domain.model.Room;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationInputDTO {
	
	@NotBlank
	private Customer customer;
	
	@NotBlank(message = "Escolha seu quarto.")
	private Room room;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate checkIn;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate checkOut;
	
	@NotBlank
	private Double totalPrice;
	
	@NotBlank
	private ReservationStatus status;

}
