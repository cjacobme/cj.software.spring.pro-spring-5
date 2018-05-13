package cj.software.spring.pro5.ch03;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import cj.software.spring.pro5.ch03.annotated.Singer;

public class DependsOnTest
{
	@Test
	public void dependsOnDemo()
	{
		try (GenericXmlApplicationContext lCtx = new GenericXmlApplicationContext())
		{
			lCtx.load("classpath:spring/app-context-01-xml.xml");
			lCtx.refresh();

			Singer lJohn = lCtx.getBean("johnMayer", Singer.class);
			String lSong = lJohn.sing();
			assertThat(lSong).as("sung").isEqualTo("Cm Eb Fm Ab Bb");
		}
	}
}
