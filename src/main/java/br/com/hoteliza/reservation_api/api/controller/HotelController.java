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

import br.com.hoteliza.reservation_api.api.model.HotelInputDTO;
import br.com.hoteliza.reservation_api.api.model.HotelOutputDTO;
import br.com.hoteliza.reservation_api.assembler.HotelAssembler;
import br.com.hoteliza.reservation_api.domain.service.HotelService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/hotel")
public class HotelController {

	private HotelAssembler hotelAssembler;
	private HotelService hotelService;

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public HotelOutputDTO getMethodName(@RequestBody final @Valid HotelInputDTO hotelInputDTO) {
		return hotelAssembler.toDto(hotelService.register(hotelAssembler.toHotel(hotelInputDTO)));
	}

	@PutMapping("/{hotelId}")
	public ResponseEntity<HotelOutputDTO> update(@PathVariable final @NotNull Long hotelId,
			@RequestBody @Valid final HotelInputDTO hotelInputDTO) {
		return ResponseEntity
				.ok(hotelAssembler.toDto(hotelService.update(hotelAssembler.toHotel(hotelInputDTO), hotelId)));
	}

	@GetMapping("/{hotelId}")
	public HotelOutputDTO consult(@PathVariable final @NotNull Long hotelId) {
		return hotelAssembler.toDto(hotelService.search(hotelId));
	}

	@GetMapping("/list")
	public List<HotelOutputDTO> list() {
		return hotelAssembler.toCollectionDto(hotelService.list());
	}

}
