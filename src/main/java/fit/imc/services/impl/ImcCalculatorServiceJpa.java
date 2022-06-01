package fit.imc.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fit.imc.helpers.Converter;
import fit.imc.models.jpa.Person;
import fit.imc.repositories.impl.ImcPersonJpaRepository;
import fit.imc.services.abstracts.ImcCalculatorServiceTemplate;
import fit.imc.view.PersonViewModel;

@Service
public class ImcCalculatorServiceJpa implements ImcCalculatorServiceTemplate<Person> {

    @Autowired
    private ImcPersonJpaRepository personRepo;

    public PersonViewModel calculate(PersonViewModel person) {
        var personModel = new Person();
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
        return Converter.toPersonViewModel(personRepo.findById(id).get());
    }

    @Override
    public PersonViewModel getOneById(UUID id) {
        throw new NotYetImplementedException();
    }

    @Override
    public List<PersonViewModel> getByImcDescription(String description) {
        return personRepo.getByImcDescription(description)
            .stream()
            .map((p) -> Converter.toPersonViewModel(p))
            .toList();

    }
}
