package fit.imc.repositories.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fit.imc.models.jpa.Person;

public interface ImcPersonJpaRepository extends JpaRepository<Person, Long> {
    List<Person> getByImcDescription(String imcDescription);
}
