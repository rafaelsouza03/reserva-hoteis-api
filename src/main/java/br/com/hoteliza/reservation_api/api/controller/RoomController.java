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

import br.com.hoteliza.reservation_api.api.model.RoomInputDTO;
import br.com.hoteliza.reservation_api.api.model.RoomOutputDTO;
import br.com.hoteliza.reservation_api.assembler.RoomAssembler;
import br.com.hoteliza.reservation_api.domain.service.RoomService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/rooms")
public class RoomController {

	private RoomAssembler roomAssembler;
	private RoomService roomService;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public RoomOutputDTO getMethodName(@RequestBody final @Valid RoomInputDTO roomInputDTO) {
		return roomAssembler.toDto(roomService.register(roomAssembler.toRoom(roomInputDTO)));
	}

	@PutMapping("/{roomId}")
	public ResponseEntity<RoomOutputDTO> update(@PathVariable final @NotNull Long roomId,
			@RequestBody @Valid final RoomInputDTO roomInputDTO) {
		return ResponseEntity.ok(roomAssembler.toDto(roomService.update(roomAssembler.toRoom(roomInputDTO), roomId)));
	}

	@GetMapping("/{roomId}")
	public RoomOutputDTO consult(@PathVariable final @NotNull Long roomId) {
		return roomAssembler.toDto(roomService.search(roomId));
	}

	@GetMapping("/list")
	public List<RoomOutputDTO> list() {
		return roomAssembler.toCollectionDto(roomService.list());
	}

}
