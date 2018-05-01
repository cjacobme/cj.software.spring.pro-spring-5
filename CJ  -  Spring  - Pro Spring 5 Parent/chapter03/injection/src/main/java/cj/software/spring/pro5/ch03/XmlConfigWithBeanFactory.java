package cj.software.spring.pro5.ch03;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class XmlConfigWithBeanFactory
{
	public static void main(String[] pArgs)
	{
		DefaultListableBeanFactory lFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader lBeanDefinitionReader = new XmlBeanDefinitionReader(lFactory);
		ClassPathResource lClassPathResource = new ClassPathResource(
				"spring/xml-bean-factory-config.xml");
		lBeanDefinitionReader.loadBeanDefinitions(lClassPathResource);
		Oracle lOracle = lFactory.getBean("oracle", Oracle.class);
		System.out.println(lOracle.defineMeaningOfLife());
	}
}
