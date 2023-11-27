package es.jsomoza.aopBasic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Person person = (Person) context.getBean("person");
		System.out.println("Person was created: " + person);
		
		person.saySomething();
		person.saySomething();
			
		((ConfigurableApplicationContext) context).close();
	}
}