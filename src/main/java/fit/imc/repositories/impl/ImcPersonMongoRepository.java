package fit.imc.repositories.impl;

import org.springframework.data.mongodb.repository.MongoRepository;

import fit.imc.models.mongo.Person;

public interface ImcPersonMongoRepository extends MongoRepository<Person, Long> {
}
