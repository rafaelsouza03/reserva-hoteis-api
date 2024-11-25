package br.com.hoteliza.reservation_api.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.hoteliza.reservation_api.domain.model.HotelOwner;
import br.com.hoteliza.reservation_api.domain.repository.HotelOwnerRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class HotelOwnerService {

	private HotelOwnerRepository hotelOwnerRepository;

	@Transactional
	public HotelOwner register(final HotelOwner hotelOwner) {
		return hotelOwnerRepository.save(hotelOwner);
	}

	@Transactional
	public HotelOwner update(final HotelOwner hotelOwner, Long hotelOwnerId) {
		HotelOwner findHotelOwner = search(hotelOwnerId);

		findHotelOwner.setName(hotelOwner.getName());
		findHotelOwner.setEmail(hotelOwner.getEmail());
		findHotelOwner.setPassword(hotelOwner.getPassword());
		findHotelOwner.setHotel(hotelOwner.getHotel());

		return hotelOwnerRepository.save(findHotelOwner);
	}

	@Transactional
	public HotelOwner search(final Long hotelOwnerId) {
		return hotelOwnerRepository.findById(hotelOwnerId)
				.orElseThrow(() -> new EntityNotFoundException("Proprietário não encontrado"));
	}

	@Transactional
	public List<HotelOwner> list() {
		return hotelOwnerRepository.findAll();
	}

}
