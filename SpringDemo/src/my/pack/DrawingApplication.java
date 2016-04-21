package my.pack;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class DrawingApplication {
	public static void main(String[] args) {
//		Triangle triangle = new Triangle();
		ApplicationContext cntxt = new ClassPathXmlApplicationContext("spring.xml");
//		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		Triangle triangle = (Triangle)cntxt.getBean("triangle");
		triangle.draw();
	}
}
