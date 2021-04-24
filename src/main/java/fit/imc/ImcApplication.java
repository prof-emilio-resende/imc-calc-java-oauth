package fit.imc;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import fit.imc.models.mongo.User;
import fit.imc.services.abstracts.UserServiceTemplate;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {fit.imc.models.jpa.Person.class, fit.imc.repositories.impl.ImcPersonJpaRepository.class})
@EnableMongoRepositories(basePackageClasses = {fit.imc.models.mongo.Person.class, fit.imc.repositories.impl.ImcPersonMongoRepository.class})
public class ImcApplication {

	@Autowired
	private UserServiceTemplate service;

	public static void main(String[] args) {
		SpringApplication.run(ImcApplication.class, args);
	}

	@PostConstruct
	public void seedUsers() {
		if (service.getAll().isEmpty()) {
			var users = List.of(new User("user", "password"));
			users.forEach(user -> service.add(user));
		}
	}

}
