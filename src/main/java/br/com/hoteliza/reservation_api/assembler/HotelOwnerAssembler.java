package br.com.hoteliza.reservation_api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.hoteliza.reservation_api.api.model.user.hotel_owner.HotelOwnerInputDTO;
import br.com.hoteliza.reservation_api.api.model.user.hotel_owner.HotelOwnerOutputDTO;
import br.com.hoteliza.reservation_api.domain.model.HotelOwner;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class HotelOwnerAssembler {

	private ModelMapper modelMapper;

	public HotelOwner toHotelOwner(final HotelOwnerInputDTO hotelOwnerInputDTO) {
		return modelMapper.map(hotelOwnerInputDTO, HotelOwner.class);
	}

	public HotelOwnerOutputDTO toDto(final HotelOwner hotelOwner) {
		return modelMapper.map(hotelOwner, HotelOwnerOutputDTO.class);
	}

	public List<HotelOwnerOutputDTO> toCollectionDto(final List<HotelOwner> hotelOwners) {
		return hotelOwners.stream().map(this::toDto).collect(Collectors.toList());
	}
	
}
