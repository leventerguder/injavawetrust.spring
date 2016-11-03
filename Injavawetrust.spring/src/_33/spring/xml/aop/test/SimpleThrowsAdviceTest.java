package _33.spring.xml.aop.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import _33.spring.xml.aop.service.Validator;

public class SimpleThrowsAdviceTest {
	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("33.spring.xml.aop.xml");

		Validator validator = context.getBean("proxyThrows", Validator.class);

		try {
			validator.validateAge(-10);
		} catch (ArithmeticException e) {

		}

		try {
			validator.parseAge("Exception");
		} catch (NumberFormatException e) {

		}

		validator.throwRuntimeException();
		
		context.close();

	}

}