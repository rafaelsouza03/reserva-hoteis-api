package br.com.hoteliza.reservation_api.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.hoteliza.reservation_api.domain.model.Hotel;
import br.com.hoteliza.reservation_api.domain.repository.HotelRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class HotelService {

	private HotelRepository hotelRepository;

	@Transactional
	public Hotel register(final Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@Transactional
	public Hotel update(final Hotel hotel, Long hotelId) {
		Hotel findHotel = search(hotelId);

		findHotel.setName(hotel.getName());
		findHotel.setAddress(hotel.getAddress());
		findHotel.setFacilites(hotel.getFacilites());
		findHotel.setOwner(hotel.getOwner());
		findHotel.setPolicy(hotel.getPolicy());
		findHotel.setRooms(hotel.getRooms());
		findHotel.setVicinities(hotel.getVicinities());

		return hotelRepository.save(findHotel);
	}

	@Transactional
	public Hotel search(final Long hotelId) {
		return hotelRepository.findById(hotelId).orElseThrow(() -> new EntityNotFoundException("Hotel não encontrado"));
	}
	
	@Transactional
	public List<Hotel> list(){
		return hotelRepository.findAll();
	}
}
