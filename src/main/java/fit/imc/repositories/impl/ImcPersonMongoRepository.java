package fit.imc.repositories.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import fit.imc.models.mongo.Person;

public interface ImcPersonMongoRepository extends MongoRepository<Person, UUID> {
    List<Person> getByImcDescription(String imcDescription);
}
