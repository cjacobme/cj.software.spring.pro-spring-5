package cj.software.spring.pro5.ch04.lifecycle;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.support.GenericXmlApplicationContext;

public class InitializingInterfaceTest
{
	private static GenericXmlApplicationContext appCtx;

	@BeforeClass
	public static void loadBeans()
	{
		InitializingInterfaceTest.appCtx = new GenericXmlApplicationContext();
		InitializingInterfaceTest.appCtx.load("classpath:spring/app-context-xml.xml");
		InitializingInterfaceTest.appCtx.refresh();
	}

	@AfterClass
	public static void releaseCtx()
	{
		if (InitializingInterfaceTest.appCtx != null)
		{
			InitializingInterfaceTest.appCtx.close();
		}
	}

	@Test
	public void nameAndAgeSet()
	{
		SingerWithInterface lSinger = (SingerWithInterface) InitializingInterfaceTest.appCtx
				.getBean("singerOneIf");
		assertThat(lSinger.getName()).as("singer one's name").isEqualTo("Mick Jagger");
		assertThat(lSinger.getAge()).as("singer one's age").isEqualTo(82);
	}

	@Test
	public void onlyAgeSet()
	{
		SingerWithInterface lSinger = (SingerWithInterface) InitializingInterfaceTest.appCtx
				.getBean("singerTwoIf");
		assertThat(lSinger.getName()).as("singer two's name").isEqualTo("Eric Clapton");
		assertThat(lSinger.getAge()).as("singer two's age").isEqualTo(75);
	}

	@Test
	public void noAgeThrowsException()
	{
		try
		{
			appCtx.getBean("singerThreeIf");
			Assert.fail("expected exception not thrown");
		}
		catch (BeanCreationException pExpectedException)
		{
			assertThat(pExpectedException.getBeanName()).as("bean name").isEqualTo("singerThreeIf");
			Throwable lCause = pExpectedException.getCause();
			assertThat(lCause).as("exception cause").isInstanceOf(IllegalStateException.class);
		}
	}
}
