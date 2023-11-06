package ru.kulik.spring.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kulik.spring.DAO.PersonDAO;
import ru.kulik.spring.models.Person;

@Component
public class PersonaValidator implements Validator {
    private final PersonDAO personDAO;

    @Autowired
    public PersonaValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        // Посмотреть, есть ли человек с таким же email в БД
        if (personDAO.show(person.getEmail()).isPresent()) {
            errors.rejectValue("email", "", "This email is already taken");
        }
    }
}
