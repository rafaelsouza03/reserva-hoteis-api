package br.com.hoteliza.reservation_api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.hoteliza.reservation_api.api.model.HotelInputDTO;
import br.com.hoteliza.reservation_api.api.model.HotelOutputDTO;
import br.com.hoteliza.reservation_api.domain.model.Hotel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class HotelAssembler {

	private ModelMapper modelMapper;

	public Hotel toHotel(final HotelInputDTO hotelInputDTO) {
		return modelMapper.map(hotelInputDTO, Hotel.class);
	}

	public HotelOutputDTO toDto(final Hotel hotel) {
		return modelMapper.map(hotel, HotelOutputDTO.class);
	}

	public List<HotelOutputDTO> toCollectionDto(final List<Hotel> hotels) {
		return hotels.stream().map(this::toDto).collect(Collectors.toList());
	}

}
