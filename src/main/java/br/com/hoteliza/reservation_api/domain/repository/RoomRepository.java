package br.com.hoteliza.reservation_api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hoteliza.reservation_api.domain.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{

	List<Room> findByHotel_Id(Long hotelId);
	
}
