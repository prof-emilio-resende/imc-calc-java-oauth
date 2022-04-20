package fit.imc.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fit.imc.models.jpa.Person;
import fit.imc.repositories.impl.ImcPersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fit.imc.services.abstracts.ImcCalculatorServiceTemplate;
import fit.imc.view.PersonViewModel;

@BasePathAwareController
@RestController
@CrossOrigin
@RequestMapping("/imc/jwt")
public class ImcController {

    @Autowired
    ImcCalculatorServiceTemplate<Person> service;
    
    @Autowired
    ImcPersonJpaRepository imcPersonJpaRepository;

    @PostMapping("/calculate")
    public PersonViewModel calculateImc(@RequestBody PersonViewModel personInput) {
        return service.calculate(personInput);
    }

    @GetMapping("/list")
    public List<Person> list() {
        return imcPersonJpaRepository.findAllByImcNotNull();
    }

    @GetMapping("/table")
    public Map<String, String> getTable() {
        var map = new HashMap<String, String>();
    
        map.put("0", "Magreza");
        map.put("18.5", "Normal");
        map.put("24.9", "Sobrepeso");
        map.put("99", "Obesidade");

        return map;
    }
}
