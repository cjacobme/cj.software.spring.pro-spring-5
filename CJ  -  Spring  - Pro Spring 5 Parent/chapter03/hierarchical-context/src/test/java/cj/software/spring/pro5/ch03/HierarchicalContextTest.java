package cj.software.spring.pro5.ch03;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import ch.qos.logback.classic.Logger;

public class HierarchicalContextTest
{
	private Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(
			this.getClass());

	@Test
	public void hierarchical()
	{
		GenericXmlApplicationContext lParentCtx = new GenericXmlApplicationContext(
				"classpath:spring/parent-context.xml");
		try
		{
			GenericXmlApplicationContext lChildCtx = new GenericXmlApplicationContext();
			try
			{
				lChildCtx.setParent(lParentCtx);
				lChildCtx.load("classpath:spring/child-context.xml");
				lChildCtx.refresh();

				Song lSong1 = lChildCtx.getBean("song1", Song.class);
				Song lSong2 = lChildCtx.getBean("song2", Song.class);
				Song lSong3 = lChildCtx.getBean("song3", Song.class);

				assertThat(lSong1).as("song 1").isNotNull();
				this.logger.info("song 1 is \"{}\"", lSong1.getTitle());
				assertThat(lSong1.getTitle()).as("from parent ctx").isEqualTo("Gravity");

				assertThat(lSong2).as("song 2").isNotNull();
				this.logger.info("song 2 is \"{}\"", lSong2.getTitle());
				assertThat(lSong2.getTitle()).as("from child ctx").isEqualTo("No Such Thing");

				assertThat(lSong3).as("song 3").isNotNull();
				this.logger.info("song 3 is \"{}\"", lSong3.getTitle());
				assertThat(lSong3.getTitle()).as("from parent ctx").isEqualTo("Daughters");
			}
			finally
			{
				lChildCtx.close();
			}
		}
		finally
		{
			lParentCtx.close();
		}
	}
}
