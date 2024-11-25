package br.com.hoteliza.reservation_api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.hoteliza.reservation_api.api.model.ReservationInputDTO;
import br.com.hoteliza.reservation_api.api.model.ReservationOutputDTO;
import br.com.hoteliza.reservation_api.domain.model.Reservation;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ReservationAssembler {

	private ModelMapper modelMapper;

	public Reservation toReservation(final ReservationInputDTO reservationInputDTO) {
		return modelMapper.map(reservationInputDTO, Reservation.class);
	}

	public ReservationOutputDTO toDto(final Reservation reservation) {
		return modelMapper.map(reservation, ReservationOutputDTO.class);
	}

	public List<ReservationOutputDTO> toCollectionDto(final List<Reservation> Reservation) {
		return Reservation.stream().map(this::toDto).collect(Collectors.toList());
	}
	
}
