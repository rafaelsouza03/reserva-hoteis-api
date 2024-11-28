package br.com.hoteliza.reservation_api.domain.model;

import br.com.hoteliza.reservation_api.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public abstract class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NonNull
	private String name;

	@NonNull
	@Column(unique = true)
	private String email;

	@NonNull
	private String password;

	@NonNull
	@Enumerated(EnumType.STRING)
	private UserRole role;

}
