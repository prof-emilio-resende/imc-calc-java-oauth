// package fit.imc.services.impl;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import fit.imc.models.Person;
// import fit.imc.repositories.impl.ImcPersonJpaRepository;
// import fit.imc.services.abstracts.ImcCalculatorServiceTemplate;

// @Service
// public class ImcCalculatorService implements ImcCalculatorServiceTemplate {

//     @Autowired
//     private ImcPersonJpaRepository personRepo;

//     public Person calculate(Person person) {
//         person.calculate();
//         personRepo.save(person);
        
//         return person;
//     }

//     public List<Person> getAll() {
//         return personRepo.findAll();
//     }
// }
