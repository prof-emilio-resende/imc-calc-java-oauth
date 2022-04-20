package fit.imc.repositories.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import fit.imc.models.jpa.Person;

import java.util.List;

public interface ImcPersonJpaRepository extends JpaRepository<Person, Long> {
    List<Person> findAllByImcNotNull();
}
