package in.stackroute;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        PersonDAO personDAO = new PersonDAOImp();
        //personDAO.createPerson();

        Person person = new Person(1, "visnu");
        personDAO.addPerson(person);

        Person person1 = new Person(2, "shiru");
        personDAO.addPerson(person1);

        System.out.println(personDAO.getAllPerson());

    }
}
