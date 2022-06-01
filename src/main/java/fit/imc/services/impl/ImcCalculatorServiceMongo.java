package fit.imc.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fit.imc.helpers.Converter;
import fit.imc.models.mongo.Person;
import fit.imc.repositories.impl.ImcPersonMongoRepository;
import fit.imc.services.abstracts.ImcCalculatorServiceTemplate;
import fit.imc.view.PersonViewModel;

@Service
public class ImcCalculatorServiceMongo implements ImcCalculatorServiceTemplate<Person> {
    @Autowired
    private ImcPersonMongoRepository personRepo;

    @Override
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
                .map(p -> Converter.toPersonViewModel(p))
                .collect(Collectors.toList());
    }

    @Override
    public PersonViewModel getOneById(Long id) {
        throw new NotYetImplementedException();
    }

    @Override
    public PersonViewModel getOneById(UUID id) {
        return Converter.toPersonViewModel(personRepo.findById(id).get());
    }

    @Override
    public List<PersonViewModel> getByImcDescription(String description) {
        return personRepo.getByImcDescription(description)
                .stream()
                .map((p) -> Converter.toPersonViewModel(p))
                .toList();

    }
}
