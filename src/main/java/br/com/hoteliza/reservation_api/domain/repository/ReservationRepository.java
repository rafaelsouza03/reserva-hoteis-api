package br.com.hoteliza.reservation_api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hoteliza.reservation_api.domain.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
