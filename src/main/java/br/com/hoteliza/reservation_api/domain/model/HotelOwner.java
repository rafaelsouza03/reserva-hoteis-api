package br.com.hoteliza.reservation_api.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hotel_owners")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class HotelOwner extends User {

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Hotel> hotel;
	
}
