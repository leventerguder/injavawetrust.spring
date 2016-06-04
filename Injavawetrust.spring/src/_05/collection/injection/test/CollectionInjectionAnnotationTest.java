package _05.collection.injection.test;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _05.collection.injection.model.CollectionInjectionAnnotation;
import _05.collection.injection.model.Person;

public class CollectionInjectionAnnotationTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("05.collection.injection.annotation.xml");

		CollectionInjectionAnnotation collectionInjection = ctx.getBean("collectionInjectionAnnotation",
				CollectionInjectionAnnotation.class);

		List<String> myList = collectionInjection.getMyList();
		List<Person> myPerson = collectionInjection.getPersonList();
		Set<Integer> mySet = collectionInjection.getMySet();
		Map<String, Object> myMap = collectionInjection.getMyMap();
		Properties myProperties = collectionInjection.getMyProperties();

		System.out.println("myList elements : ");
		for (String element : myList) {
			System.out.println(element);
		}

		System.out.println("myPerson elements : ");
		for (Person element : myPerson) {
			System.out.println(element);
		}

		System.out.println("mySet elements : ");
		for (Integer element : mySet) {
			System.out.println(element);
		}

		System.out.println("myMap elements : ");
		for (Object element : myMap.keySet()) {
			System.out.println(myMap.get(element));
		}

		System.out.println("myProperties elements : ");
		for (Map.Entry<Object, Object> entry : myProperties.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		((ClassPathXmlApplicationContext) ctx).close();
	}
}
