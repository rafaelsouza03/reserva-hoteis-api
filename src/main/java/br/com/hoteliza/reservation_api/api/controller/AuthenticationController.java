package br.com.hoteliza.reservation_api.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hoteliza.reservation_api.api.model.user.AuthenticationDTO;
import br.com.hoteliza.reservation_api.api.model.user.LoginResponseDTO;
import br.com.hoteliza.reservation_api.api.model.user.RegisterDTO;
import br.com.hoteliza.reservation_api.domain.model.Customer;
import br.com.hoteliza.reservation_api.domain.model.HotelOwner;
import br.com.hoteliza.reservation_api.domain.model.User;

import br.com.hoteliza.reservation_api.domain.repository.UserRepository;
import br.com.hoteliza.reservation_api.enums.UserRole;
import br.com.hoteliza.reservation_api.infra.security.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository repository;

	@Autowired
	private TokenService tokenService;

	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);

		var token = tokenService.generateToken((User) auth.getPrincipal());

		return ResponseEntity.ok(new LoginResponseDTO(token));
	}

	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
		if (this.repository.findByEmail(data.email()) != null)
			return ResponseEntity.badRequest().build();

		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		User newUser;

		if (data.role() == UserRole.CUSTOMER) {
			newUser = Customer.builder().name(data.name()).email(data.email()).password(encryptedPassword)
					.role(data.role()).build();
		} else if (data.role() == UserRole.OWNER) {
			newUser = HotelOwner.builder().name(data.name()).email(data.email()).password(encryptedPassword)
					.role(data.role()).build();
		} else {
			throw new IllegalArgumentException("Invalid role: " + data.role());
		}

		this.repository.save(newUser);

		return ResponseEntity.ok().build();
	}
}