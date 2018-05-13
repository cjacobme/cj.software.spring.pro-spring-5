package cj.software.spring.pro5.ch03;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import ch.qos.logback.classic.Logger;
import cj.software.spring.pro5.ch03.annotated.Singer;

public class NonSingletonTest
{
	private Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(
			this.getClass());

	@Test
	public void nonSingleton()
	{
		try (GenericXmlApplicationContext lCtx = new GenericXmlApplicationContext())
		{
			lCtx.load("spring/app-context-xml.xml");
			lCtx.refresh();

			Singer lSinger1 = lCtx.getBean("nonSingleton", Singer.class);
			Singer lSinger2 = lCtx.getBean("nonSingleton", Singer.class);

			assertThat(lSinger1).as("is same").isNotSameAs(lSinger2);
			assertThat(lSinger1).as("is equal").isNotEqualTo(lSinger2);
			assertThat(lSinger1.getName()).as("name").isEqualTo(lSinger2.getName());
			this.logger.info("singer #1 name={}", lSinger1.getName());
		}
	}
}
