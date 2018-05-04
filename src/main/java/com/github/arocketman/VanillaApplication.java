package com.github.arocketman;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.github.arocketman.config.CustomUserDetails;
import com.github.arocketman.entities.Role;
import com.github.arocketman.entities.Usuario;
import com.github.arocketman.repositories.UsuarioRepository;
import com.github.arocketman.services.UsuarioService;


@SpringBootApplication
public class VanillaApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(VanillaApplication.class, args);
	}

	/**
	 * Password grants are switched on by injecting an AuthenticationManager.
	 * Here, we setup the builder so that the userDetailsService is the one we coded.
	 * 
	 * As senhas devem ser criptografadas antes de ser salvas na base.
	 * @see {@link https://www.dailycred.com/article/bcrypt-calculator}
	 * 
	 * @param builder
	 * @param repository
	 * @throws Exception
     */
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UsuarioRepository repository, UsuarioService service) throws Exception {
		//Setup a default user if db is empty
		if (repository.count()==0)
			service.save(new Usuario("josue", "josue", Arrays.asList(new Role("ADMIN"), new Role("ACTUATOR"))));
		builder.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);
	}

	/**
	 * We return an istance of our CustomUserDetails.
	 * @param repository
	 * @return
     */
	private UserDetailsService userDetailsService(final UsuarioRepository repository) {
		return nome -> new CustomUserDetails(repository.findByNome(nome));
	}
	
}
