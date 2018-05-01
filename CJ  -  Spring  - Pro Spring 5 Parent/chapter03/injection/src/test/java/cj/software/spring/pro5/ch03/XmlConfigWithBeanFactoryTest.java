package cj.software.spring.pro5.ch03;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class XmlConfigWithBeanFactoryTest
{
	@Test
	public void xmlBeanFactory()
	{
		DefaultListableBeanFactory lFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader lBeanDefinitionReader = new XmlBeanDefinitionReader(lFactory);
		ClassPathResource lClassPathResource = new ClassPathResource(
				"spring/xml-bean-factory-config.xml");
		lBeanDefinitionReader.loadBeanDefinitions(lClassPathResource);
		Oracle lOracle = lFactory.getBean("oracle", Oracle.class);
		String lAnswer = lOracle.defineMeaningOfLife();
		System.out.println(lAnswer);
		assertThat(lAnswer).as("answer from Oracle").isEqualTo(
				"Encyclopedias are a waste of time - go see the world instead");
	}
}
