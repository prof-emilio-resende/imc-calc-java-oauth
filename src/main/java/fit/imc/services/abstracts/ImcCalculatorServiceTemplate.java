package fit.imc.services.abstracts;

import java.util.List;
import java.util.UUID;

import fit.imc.view.PersonViewModel;

public interface ImcCalculatorServiceTemplate<T> {
    public List<PersonViewModel> getAll();
    public PersonViewModel calculate(PersonViewModel person);
    public PersonViewModel getOneById(Long id);
    public PersonViewModel getOneById(UUID id);
    public List<PersonViewModel> getByImcDescription(String description);
}
