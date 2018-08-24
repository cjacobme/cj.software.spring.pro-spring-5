package cj.software.spring.pro5.ch04.lifecycle;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Jsr250Test
{
	private static GenericXmlApplicationContext appCtx;

	@BeforeClass
	public static void loadBeans()
	{
		Jsr250Test.appCtx = new GenericXmlApplicationContext();
		Jsr250Test.appCtx.load("classpath:spring/app-context-xml.xml");
		Jsr250Test.appCtx.refresh();
	}

	@AfterClass
	public static void releaseCtx()
	{
		if (Jsr250Test.appCtx != null)
		{
			Jsr250Test.appCtx.close();
		}
	}

	@Test
	public void nameAndAgeSet()
	{
		SingerJsr250 lSinger = (SingerJsr250) Jsr250Test.appCtx.getBean("singerOneJsr250");
		assertThat(lSinger.getName()).as("singer one's name").isEqualTo("Peter Gabriel");
		assertThat(lSinger.getAge()).as("singer one's age").isEqualTo(79);
	}

	@Test
	public void onlyAgeSet()
	{
		SingerJsr250 lSinger = (SingerJsr250) Jsr250Test.appCtx.getBean("singerTwoJsr250");
		assertThat(lSinger.getName()).as("singer two's name").isEqualTo("Eric Clapton");
		assertThat(lSinger.getAge()).as("singer two's age").isEqualTo(73);
	}

	@Test
	public void noAgeThrowsException()
	{
		try
		{
			appCtx.getBean("singerThreeJsr250");
			Assert.fail("expected exception not thrown");
		}
		catch (BeanCreationException pExpectedException)
		{
			assertThat(pExpectedException.getBeanName()).as("bean name").isEqualTo(
					"singerThreeJsr250");
			Throwable lCause = pExpectedException.getCause();
			assertThat(lCause).as("exception cause").isInstanceOf(IllegalStateException.class);
		}
	}
}
