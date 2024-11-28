package br.com.hoteliza.reservation_api.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.hoteliza.reservation_api.domain.model.Room;
import br.com.hoteliza.reservation_api.domain.repository.RoomRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RoomService {

	private RoomRepository roomRepository;

	@Transactional
	public Room register(final Room room) {
		return roomRepository.save(room);
	}

	@Transactional
	public Room update(final Room room, Long roomId) {
		Room findRoom = search(roomId);

		findRoom.setBedAmount(room.getBedAmount());
		findRoom.setPeopleCapacity(room.getPeopleCapacity());
		findRoom.setPricePerDay(room.getPricePerDay());
		findRoom.setType(room.getType());

		return roomRepository.save(findRoom);
	}

	@Transactional
	public Room search(Long roomId) {
		return roomRepository.findById(roomId).orElseThrow(() -> new EntityNotFoundException("Quarto não encontrado"));
	}
	
	@Transactional
	public List<Room> listByHotel(Long hotelId){
		return roomRepository.findByHotel_Id(hotelId);
	}
	
	

}
