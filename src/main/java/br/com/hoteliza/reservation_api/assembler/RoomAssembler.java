package br.com.hoteliza.reservation_api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.hoteliza.reservation_api.api.model.RoomInputDTO;
import br.com.hoteliza.reservation_api.api.model.RoomOutputDTO;
import br.com.hoteliza.reservation_api.domain.model.Room;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class RoomAssembler {

	private ModelMapper modelMapper;

	public Room toRoom(final RoomInputDTO roomInputDTO) {
		return modelMapper.map(roomInputDTO, Room.class);
	}

	public RoomOutputDTO toDto(final Room room) {
		return modelMapper.map(room, RoomOutputDTO.class);
	}

	public List<RoomOutputDTO> toCollectionDto(final List<Room> rooms) {
		return rooms.stream().map(this::toDto).collect(Collectors.toList());
	}

}
