package br.com.hoteliza.reservation_api.api.model;

import java.util.List;

import br.com.hoteliza.reservation_api.domain.model.HotelOwner;
import br.com.hoteliza.reservation_api.domain.model.Room;
import br.com.hoteliza.reservation_api.enums.Facility;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelOutputDTO extends HotelBaseDTO{
	
	private String name;
	
	private List<Facility> facilities;
	
	private String address;
	
	private List<String> vicinities;
	
	private String policy;
	
	private HotelOwner owner;
	
	private List<Room> rooms;

}
