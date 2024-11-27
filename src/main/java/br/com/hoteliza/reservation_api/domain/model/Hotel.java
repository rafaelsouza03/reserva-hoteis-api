package br.com.hoteliza.reservation_api.domain.model;

import java.util.List;

import br.com.hoteliza.reservation_api.enums.Facility;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hotels")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String name;

	@ElementCollection
	@CollectionTable(name = "comodidades", joinColumns = @JoinColumn(name = "hotel_id"))
	private List<Facility> facilites;

	@Column(name = "endereço", nullable = false)
	private String address;

	// private List<String> pictures;

	@ElementCollection
	@CollectionTable(name = "proximidades", joinColumns = @JoinColumn(name = "hotel_id"))
	private List<String> vicinities;

	@Column(name = "politicas")
	private String policy;

	@ManyToOne
	@JoinColumn(name = "proprietario_id")
	private HotelOwner owner;

	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	private List<Room> rooms;

}
