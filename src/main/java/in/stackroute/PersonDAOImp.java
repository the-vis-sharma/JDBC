package in.stackroute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonDAOImp implements PersonDAO {

    @Autowired
    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public void createPerson() {
        template.execute("create table person (id integer, name char(30))");
    }

    @Override
    public Person getPersonById(int id) {
        Person person = template.queryForObject("select * from person where id = ? limit 1", Person.class);
        return person;
    }

    @Override
    public List<Person> getAllPerson() {
        List<Person> personList = template.query("select * from person", new RowMapper<Person>() {
            @Override
            public Person mapRow(ResultSet resultSet, int i) throws SQLException {
                Person person = new Person(resultSet.getInt("id"), resultSet.getString("name"));
                return person;
            }
        });
        return personList;
    }

    @Override
    public void addPerson(Person person) {
        template.update("insert  into  person values (?, ?)", new Object[]{ person.getId(), person.getName() });
    }

    @Override
    public void deletePerson() {

    }

    @Override
    public void updatePerson() {

    }
}
