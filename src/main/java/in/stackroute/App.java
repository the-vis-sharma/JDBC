package in.stackroute;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        PersonDAO personDAO = context.getBean("personDAO", PersonDAO.class);
        //personDAO.createPerson();

        /*Person person = new Person(1, "visnu");
        personDAO.addPerson(person);

        Person person1 = new Person(2, "shiru");
        personDAO.addPerson(person1);*/

        System.out.println(personDAO.getAllPerson());

    }
}
