package br.com.hoteliza.reservation_api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hoteliza.reservation_api.domain.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

}