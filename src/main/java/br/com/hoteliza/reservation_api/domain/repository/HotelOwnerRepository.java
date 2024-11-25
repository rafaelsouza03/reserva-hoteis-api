package br.com.hoteliza.reservation_api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hoteliza.reservation_api.domain.model.HotelOwner;

public interface HotelOwnerRepository extends JpaRepository<HotelOwner, Long>{

}
