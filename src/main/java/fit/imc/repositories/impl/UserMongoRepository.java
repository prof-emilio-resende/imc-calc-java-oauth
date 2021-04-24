package fit.imc.repositories.impl;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import fit.imc.models.mongo.User;

public interface UserMongoRepository extends MongoRepository<User, UUID> {
    
}
