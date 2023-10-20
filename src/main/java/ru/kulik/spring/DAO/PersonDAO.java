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

        people.add(new Person(++PEOPLE_COUNT, "Tom", 23, "tom@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Vik", 34, "vik@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 22, "bob23@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", 28, "mike@mail.ru"));
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

    public void update(int id, Person personUpdate) {
        Person person = show(id);
        person.setName(personUpdate.getName());
        person.setAge(personUpdate.getAge());
        person.setEmail(personUpdate.getEmail());
    }

    public void delete(int id) {
        Person person = show(id);
        people.remove(person);
        // или используем лямбда выражение
        // people.removeIf(p -> p.getId() == id);
    }
}
