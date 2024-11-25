package br.com.hoteliza.reservation_api.domain.model;

import java.time.LocalDate;

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

@Entity
@Table(name = "reservations")
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
