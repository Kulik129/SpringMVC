package ru.kulik.spring.DAO;

import org.springframework.stereotype.Component;
import ru.kulik.spring.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;
    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Vik"));
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT, "Mike "));
    }
    //    List<Person> people = new ArrayList<>();
    public List<Person> index() {
//        people.add(new Person(++PEOPLE_COUNT, "Tom"));
//        people.add(new Person(++PEOPLE_COUNT, "Vik"));
//        people.add(new Person(++PEOPLE_COUNT, "Bob"));
//        people.add(new Person(++PEOPLE_COUNT, "Mike "));
        return people;
    }
    public Person show(int id) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).getId() == id) {
                return people.get(i);
            }
        }
        return null;
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
