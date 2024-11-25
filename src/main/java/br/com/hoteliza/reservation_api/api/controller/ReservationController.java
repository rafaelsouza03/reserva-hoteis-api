package br.com.hoteliza.reservation_api.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping("/reservations")
public class ReservationController {

	private ReservationAssembler reservationAssembler;
	private ReservationService reservationService;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ReservationOutputDTO getMethodName(@RequestBody final @Valid ReservationInputDTO reservationInputDTO) {
		return reservationAssembler
				.toDto(reservationService.register(reservationAssembler.toReservation(reservationInputDTO)));
	}

	@PutMapping("/{reservationId}")
	public ResponseEntity<ReservationOutputDTO> update(@PathVariable final @NotNull Long reservationId,
			@RequestBody @Valid final ReservationInputDTO reservationInputDTO) {
		return ResponseEntity.ok(reservationAssembler.toDto(
				reservationService.update(reservationAssembler.toReservation(reservationInputDTO), reservationId)));
	}

	@GetMapping("/{reservationId}")
	public ReservationOutputDTO consult(@PathVariable final @NotNull Long reservationId) {
		return reservationAssembler.toDto(reservationService.search(reservationId));
	}

	@GetMapping("/list")
	public List<ReservationOutputDTO> list() {
		return reservationAssembler.toCollectionDto(reservationService.list());
	}

}
