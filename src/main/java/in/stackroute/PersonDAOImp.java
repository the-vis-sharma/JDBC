package in.stackroute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDAOImp implements PersonDAO {

    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void createPerson() {
        try (Connection conn = dataSource.getConnection()){
            Statement stmt = conn.createStatement();
            System.out.println(stmt.executeUpdate("create table person (id integer, name char(30))"));
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Person getPersonById(int id) {
        Person person = null;
        try (Connection conn = dataSource.getConnection()){
            String sql = "select * from person where id = ? limit 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                person = new Person(rs.getInt("id"), rs.getString("name"));
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    @Override
    public List<Person> getAllPerson() {
        List<Person> personList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()){
            String sql = "select * from person";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                personList.add(new Person(rs.getInt("id"), rs.getString("name")));
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personList;
    }

    @Override
    public void addPerson(Person person) {
        try (Connection conn = dataSource.getConnection()){
            String sql = "insert  into  person values (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, person.getId());
            stmt.setString(2, person.getName());
            System.out.println(stmt.executeUpdate());
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletePerson() {

    }

    @Override
    public void updatePerson() {

    }
}
