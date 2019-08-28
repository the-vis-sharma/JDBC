package in.stackroute;

import java.util.List;

public interface PersonDAO {

    void createPerson();

    Person getPersonById(int id);

    List<Person> getAllPerson();

    void addPerson(Person person);

    void deletePerson();

    void updatePerson();

}
