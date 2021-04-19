package fit.imc.services.abstracts;

import java.util.List;

import fit.imc.view.PersonViewModel;

public interface ImcCalculatorServiceTemplate<T> {
    public List<PersonViewModel> getAll();
    public PersonViewModel calculate(PersonViewModel person);
}
