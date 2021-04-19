package fit.imc.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fit.imc.models.mongo.Person;
import fit.imc.repositories.impl.ImcPersonMongoRepository;
import fit.imc.services.abstracts.ImcCalculatorServiceTemplate;
import fit.imc.view.PersonViewModel;

@Service
public class ImcCalculatorServiceMongo implements ImcCalculatorServiceTemplate {
    @Autowired
    private ImcPersonMongoRepository personRepo;

    public PersonViewModel calculate(PersonViewModel person) {
        var personModel = new Person();
        personModel.setId(UUID.randomUUID());
        personModel.setHeight(person.height);
        personModel.setWeight(person.weight);
        personModel.calculate();
        personRepo.save(personModel);
        
        person.imc = personModel.getImc();
        person.imcDescription = personModel.getImcDescription();
        return person;
    }

    public List<PersonViewModel> getAll() {
        return personRepo
            .findAll()
            .stream()
            .map(p -> {
                var person = new PersonViewModel();
                person.height = p.getHeight();
                person.weight = p.getWeight();
                person.imc = p.getImc();
                person.imcDescription = p.getImcDescription();
                
                return person;
            })
            .collect(Collectors.toList());
    }
}
