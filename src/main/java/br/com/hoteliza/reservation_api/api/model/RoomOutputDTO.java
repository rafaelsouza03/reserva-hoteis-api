package br.com.hoteliza.reservation_api.api.model;

import br.com.hoteliza.reservation_api.domain.model.Hotel;
import br.com.hoteliza.reservation_api.enums.RoomType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomOutputDTO extends RoomBaseDTO{
	
	private RoomType roomType;
	
	private Integer bedAmount;
	
	private Integer peopleCapacity;
	
	private Double pricePerDay;
	
	private Hotel hotel;

}
