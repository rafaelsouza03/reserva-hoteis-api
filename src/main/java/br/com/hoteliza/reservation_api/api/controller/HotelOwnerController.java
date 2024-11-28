package br.com.hoteliza.reservation_api.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hoteliza.reservation_api.api.model.user.hotel_owner.HotelOwnerInputDTO;
import br.com.hoteliza.reservation_api.api.model.user.hotel_owner.HotelOwnerOutputDTO;
import br.com.hoteliza.reservation_api.assembler.HotelOwnerAssembler;
import br.com.hoteliza.reservation_api.domain.service.HotelOwnerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/hotel_owner")
public class HotelOwnerController {

	private HotelOwnerAssembler hotelOwnerAssembler;
	private HotelOwnerService hotelOwnerService;

	@PutMapping("/{hotelOwnerId}")
	public ResponseEntity<HotelOwnerOutputDTO> update(@PathVariable final @NotNull Long hotelOwnerId,
			@RequestBody @Valid final HotelOwnerInputDTO hotelOwnerInputDTO) {
		return ResponseEntity.ok(hotelOwnerAssembler
				.toDto(hotelOwnerService.update(hotelOwnerAssembler.toHotelOwner(hotelOwnerInputDTO), hotelOwnerId)));
	}

	@GetMapping("/{hotelOwnerId}")
	public HotelOwnerOutputDTO consult(@PathVariable final @NotNull Long hotelOwnerId) {
		return hotelOwnerAssembler.toDto(hotelOwnerService.search(hotelOwnerId));
	}

}
