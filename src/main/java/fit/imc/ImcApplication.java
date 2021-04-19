package fit.imc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {fit.imc.models.jpa.Person.class, fit.imc.repositories.impl.ImcPersonJpaRepository.class})
@EnableMongoRepositories(basePackageClasses = {fit.imc.models.mongo.Person.class, fit.imc.repositories.impl.ImcPersonMongoRepository.class})
public class ImcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImcApplication.class, args);
	}

}
