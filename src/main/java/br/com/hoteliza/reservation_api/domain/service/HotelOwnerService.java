package br.com.hoteliza.reservation_api.domain.service;

import org.springframework.stereotype.Service;

import br.com.hoteliza.reservation_api.domain.model.HotelOwner;
import br.com.hoteliza.reservation_api.domain.model.User;
import br.com.hoteliza.reservation_api.domain.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class HotelOwnerService {

	private UserRepository userRepository;

	@Transactional
	public HotelOwner update(final HotelOwner hotelOwner, Long hotelOwnerId) {
		HotelOwner findHotelOwner = search(hotelOwnerId);

		findHotelOwner.setName(hotelOwner.getName());
		findHotelOwner.setEmail(hotelOwner.getEmail());
		findHotelOwner.setPassword(hotelOwner.getPassword());
		findHotelOwner.setHotel(hotelOwner.getHotel());

		return userRepository.save(findHotelOwner);
	}

	@Transactional
	public HotelOwner search(final Long hotelOwnerId) {
		User user = userRepository.findById(hotelOwnerId)
				.orElseThrow(() -> new EntityNotFoundException("Proprietário não encontrado."));

		if (user instanceof HotelOwner) {
			return (HotelOwner) user;
		} else {
			throw new EntityNotFoundException("O usuário encontrado não é um proprietário.");
		}
	}

}
