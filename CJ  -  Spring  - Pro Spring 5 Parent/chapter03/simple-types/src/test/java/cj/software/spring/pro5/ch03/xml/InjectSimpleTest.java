package cj.software.spring.pro5.ch03.xml;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectSimpleTest
{
	private static GenericXmlApplicationContext ctx;

	@BeforeClass
	public static void loadContext()
	{
		ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-xml.xml");
		ctx.refresh();
	}

	@AfterClass
	public static void closeContext()
	{
		if (ctx != null)
		{
			ctx.close();
		}
	}

	@Test
	public void standard()
	{
		InjectSimple lInstance = ctx.getBean("injectSimpleConfig", InjectSimple.class);
		assertThat(lInstance).as("loaded instance").isNotNull();
		System.out.println(lInstance.toString());
		assertThat(lInstance.getName()).as("name").isEqualTo("John Mayer");
		assertThat(lInstance.getAge()).as("age").isEqualTo(42);
		assertThat(lInstance.getHeight()).as("height").isEqualTo(1.92f, within(0.001f));
		assertThat(lInstance.isProgrammer()).as("is programmer").isFalse();
		assertThat(lInstance.getAgeInSeconds()).as("age in seconds").isEqualTo(1241401112);
	}

	@Test
	public void programmer()
	{
		InjectSimple lInstance = ctx.getBean("programmer", InjectSimple.class);
		assertThat(lInstance).as("loaded instance").isNotNull();
		assertThat(lInstance.isProgrammer()).as("is programmer").isTrue();
	}
}
