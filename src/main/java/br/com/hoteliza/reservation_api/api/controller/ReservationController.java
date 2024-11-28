package br.com.hoteliza.reservation_api.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.hoteliza.reservation_api.api.model.ReservationInputDTO;
import br.com.hoteliza.reservation_api.api.model.ReservationOutputDTO;
import br.com.hoteliza.reservation_api.assembler.ReservationAssembler;
import br.com.hoteliza.reservation_api.domain.service.ReservationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

	private ReservationAssembler reservationAssembler;
	private ReservationService reservationService;

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public ReservationOutputDTO getMethodName(@RequestBody final @Valid ReservationInputDTO reservationInputDTO) {
		return reservationAssembler
				.toDto(reservationService.register(reservationAssembler.toReservation(reservationInputDTO)));
	}

	@GetMapping("/{reservationId}")
	public ReservationOutputDTO consult(@PathVariable final @NotNull Long reservationId) {
		return reservationAssembler.toDto(reservationService.search(reservationId));
	}

	@GetMapping("/list/hotel/{hotelId}")
	public List<ReservationOutputDTO> listByHotel(Long hotelId) {
		return reservationAssembler.toCollectionDto(reservationService.listByHotel(hotelId));
	}
	
	@GetMapping("/list/customer/{customerId}")
	public List<ReservationOutputDTO> listByCustomer(Long customerId) {
		return reservationAssembler.toCollectionDto(reservationService.listByCustomer(customerId));
	}

}
