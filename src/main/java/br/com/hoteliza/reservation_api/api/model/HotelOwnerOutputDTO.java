package br.com.hoteliza.reservation_api.api.model;

import java.util.List;

import br.com.hoteliza.reservation_api.domain.model.Hotel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelOwnerOutputDTO extends HotelOwnerBaseDTO {

	private String name;

	private String email;

	private List<Hotel> hotels;

}
