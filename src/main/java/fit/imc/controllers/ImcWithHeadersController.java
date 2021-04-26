package fit.imc.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fit.imc.models.jpa.Person;
import fit.imc.services.abstracts.ImcCalculatorServiceTemplate;
import fit.imc.view.PersonViewModel;

@RestController
@CrossOrigin
@RequestMapping("/imc-header")
public class ImcWithHeadersController {
    @Autowired
    ImcCalculatorServiceTemplate<Person> service;

    @GetMapping(value="/table", headers="Accept-version=v1")
    public Map<String, String> getTable() {
        var map = new HashMap<String, String>();
    
        map.put("0", "Magreza");
        map.put("18.5", "Normal");
        map.put("24.9", "Sobrepeso");
        map.put("99", "Obesidade");

        return map;
    }

    @PostMapping(value="/calculate", headers="Accept-version=v1")
    public PersonViewModel calculateImc(@RequestBody PersonViewModel personInput) {
        return service.calculate(personInput);
    }
}
