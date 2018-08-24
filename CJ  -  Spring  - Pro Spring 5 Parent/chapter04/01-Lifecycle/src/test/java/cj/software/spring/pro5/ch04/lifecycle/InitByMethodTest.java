package cj.software.spring.pro5.ch04.lifecycle;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.support.GenericXmlApplicationContext;

public class InitByMethodTest
{
	private static GenericXmlApplicationContext appCtx;

	@BeforeClass
	public static void loadBeans()
	{
		InitByMethodTest.appCtx = new GenericXmlApplicationContext();
		InitByMethodTest.appCtx.load("classpath:spring/app-context-xml.xml");
		InitByMethodTest.appCtx.refresh();
	}

	@AfterClass
	public static void releaseCtx()
	{
		if (InitByMethodTest.appCtx != null)
		{
			InitByMethodTest.appCtx.close();
		}
	}

	@Test
	public void nameAndAgeFromAppCtx()
	{
		Singer lSinger = (Singer) appCtx.getBean("singerOne");
		assertThat(lSinger.getName()).as("singer one's name").isEqualTo("Billy Joe Armstrong");
		assertThat(lSinger.getAge()).as("singer one's age").isEqualTo(45);
	}

	@Test
	public void defaultName()
	{
		Singer lSinger = (Singer) appCtx.getBean("singerTwo");
		assertThat(lSinger.getName()).as("singer two's name").isEqualTo("Eric Clapton");
		assertThat(lSinger.getAge()).as("singer two's age").isEqualTo(72);
	}

	@Test
	public void noAgeThrowsException()
	{
		try
		{
			appCtx.getBean("singerThree");
			Assert.fail("expected exception not thrown");
		}
		catch (BeanCreationException pExpectedException)
		{
			assertThat(pExpectedException.getBeanName()).as("bean name").isEqualTo("singerThree");
			Throwable lCause = pExpectedException.getCause();
			assertThat(lCause).as("exception cause").isInstanceOf(IllegalArgumentException.class);
		}
	}
}
