package fit.imc.helpers;

import fit.imc.view.PersonViewModel;

public class Converter {
    public static PersonViewModel toPersonViewModel(fit.imc.models.mongo.Person person) {
        var p = new PersonViewModel();
        p.height = person.getHeight();
        p.weight = person.getWeight();
        p.imc = person.getImc();
        p.imcDescription = person.getImcDescription();

        return p;
    }

    public static PersonViewModel toPersonViewModel(fit.imc.models.jpa.Person person) {
        var p = new PersonViewModel();
        p.height = person.getHeight();
        p.weight = person.getWeight();
        p.imc = person.getImc();
        p.imcDescription = person.getImcDescription();

        return p;
    }

    public static fit.imc.models.mongo.Person toNoSQLPerson(PersonViewModel vm) {
        var p = new fit.imc.models.mongo.Person();
        p.setHeight(vm.height);
        p.setWeight(vm.weight);
        p.setImc(vm.imc);
        p.setImcDescription(vm.imcDescription);

        return p;
    }

    public static fit.imc.models.jpa.Person toSQLPerson(PersonViewModel vm) {
        var p = new fit.imc.models.jpa.Person();
        p.setHeight(vm.height);
        p.setWeight(vm.weight);
        p.setImc(vm.imc);
        p.setImcDescription(vm.imcDescription);

        return p;
    }
}
