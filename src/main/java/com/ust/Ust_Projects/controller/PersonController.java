package com.ust.Ust_Projects.controller;

import com.ust.Ust_Projects.common.PersonConstant;
import com.ust.Ust_Projects.model.Person;
import com.ust.Ust_Projects.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String registerPerson(@RequestBody Person person) {
         person.setRoles(PersonConstant.DEFAULT_ROLE);
        String encodedPassword = passwordEncoder.encode(person.getPassword());
        person.setPassword(encodedPassword);
        personRepository.save(person);
        return "hi " + person.getUsername() + " your registration process successfully completed";
    }
}


