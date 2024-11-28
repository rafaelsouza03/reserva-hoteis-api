package br.com.hoteliza.reservation_api.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.hoteliza.reservation_api.domain.model.Reservation;
import br.com.hoteliza.reservation_api.domain.repository.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ReservationService {

	private ReservationRepository reservationRepository;
	
	@Transactional
	public Reservation register(final Reservation reservation) {
		return reservationRepository.save(reservation);
	}
	
	@Transactional
	public Reservation update(final Reservation reservation, Long reservationId) {
		Reservation findReservation = search(reservationId);
		
		findReservation.setCustomer(reservation.getCustomer());
		findReservation.setRoom(reservation.getRoom());
		findReservation.setStatus(reservation.getStatus());
		findReservation.setTotalPrice(reservation.getTotalPrice());
		findReservation.setCheckIn(reservation.getCheckIn());
		findReservation.setCheckOut(reservation.getCheckOut());
		
		return reservationRepository.save(findReservation);
	}
	
	@Transactional
	public Reservation search(Long reservationId) {
		return reservationRepository.findById(reservationId).orElseThrow(() -> new EntityNotFoundException("Reserva não encontrada")); 
	}
	
	@Transactional
	public List<Reservation> listByHotel(Long hotelId){
		return reservationRepository.findByHotel_Id(hotelId);
	}
	
	@Transactional
	public List<Reservation> listByCustomer(Long customerId){
		return reservationRepository.findByCustomer_Id(customerId);
	}
}
