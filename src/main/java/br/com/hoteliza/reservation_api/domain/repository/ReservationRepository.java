package br.com.hoteliza.reservation_api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hoteliza.reservation_api.domain.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	List<Reservation> findByHotel_Id(Long hotelId);
	
	List<Reservation> findByCustomer_Id(Long hotelId);
	
}
