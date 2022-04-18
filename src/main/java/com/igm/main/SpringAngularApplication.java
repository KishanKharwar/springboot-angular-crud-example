package com.igm.main;

import com.igm.main.entities.User;
import com.igm.main.repositories.UserRepository;
import java.util.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAngularApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringAngularApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringAngularApplication.class);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
				User user = new User(name, name.toLowerCase() + "@domain.com");
				userRepository.save(user);
			});
			userRepository.findAll().forEach(System.out::println);
		};
	}

}
