package com.tyss.springCore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentTest {

	public static void main(String[] args) {
		
		ApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("springconfig.xml");
		Student std =  (Student) context.getBean("student");
		System.out.println(std);
		((AbstractApplicationContext)context).close();
	}
}
