package fit.imc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fit.imc.models.mongo.User;
import fit.imc.repositories.impl.UserMongoRepository;
import fit.imc.services.abstracts.UserServiceTemplate;

@Service
public class UserService implements UserServiceTemplate {

    @Autowired
    private UserMongoRepository repository;

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public void add(User user) {
        repository.insert(user);        
    }

    
    
}
