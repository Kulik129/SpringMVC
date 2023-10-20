package ru.kulik.spring.DAO;

import org.springframework.stereotype.Component;
import ru.kulik.spring.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    public static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "12345678";

    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Person> index() {
        List<Person> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM person");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));

                list.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public Person show(int id) {
//        for (int i = 0; i < people.size(); i++) {
//            if (people.get(i).getId() == id) {
//                return people.get(i);
//            }
//        }
        return null;
    }

    public void save(Person person) {
//        person.setId(++PEOPLE_COUNT);
//        people.add(person);
    }

    public void update(int id, Person personUpdate) {
        Person person = show(id);
        person.setName(personUpdate.getName());
        person.setAge(personUpdate.getAge());
        person.setEmail(personUpdate.getEmail());
    }

    public void delete(int id) {
//        Person person = show(id);
//        people.remove(person);
//        // или используем лямбда выражение
//        // people.removeIf(p -> p.getId() == id);
    }
}
