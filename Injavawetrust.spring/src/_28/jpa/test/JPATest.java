package _28.jpa.test;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _28.jpa.model.Person;
import _28.jpa.service.PersonDAOService;


public class JPATest {
	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("28.jpa.xml");

		PersonDAOService pService = ctx.getBean(PersonDAOService.class);

		// create person object
		Person person = pService.createPerson("Lvnt", "Erguder", 1989);

		// insert
		pService.insert(person);

		// find
		Person foundPerson = pService.getPersonById(1);
		System.out.println("Found ... " + foundPerson);

		// update
		person.setName("Levent");
		pService.update(person);
		System.out.println("After Update...");

		// find
		foundPerson = pService.getPersonById(1);
		System.out.println("Found ... " + foundPerson);

		// delete
		pService.delete(1);

		Person person2 = pService.createPerson("James", "Gosling", 1955);
		Person person3 = pService.createPerson("Joshua", "Bloch", 1961);

		pService.insert(person2);
		pService.insert(person3);

		// list
		List<Person> personList = pService.getAllPersons();
		System.out.println("Listing...");
		for (Person p : personList) {
			System.out.println(p);
		}

		((ClassPathXmlApplicationContext) ctx).close();

	}
}
