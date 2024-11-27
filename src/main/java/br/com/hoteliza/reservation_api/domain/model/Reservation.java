package br.com.hoteliza.reservation_api.domain.model;

import java.time.LocalDate;

import br.com.hoteliza.reservation_api.enums.ReservationStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reservations")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "room_id")
	private Room room;

	@Temporal(TemporalType.DATE)
	@Column(name = "check_in")
	private LocalDate checkIn;

	@Temporal(TemporalType.DATE)
	@Column(name = "check_out")
	private LocalDate checkOut;

	@Column(name = "total_price")
	private Double totalPrice;

	@Enumerated(EnumType.STRING)
	private ReservationStatus status;

}
