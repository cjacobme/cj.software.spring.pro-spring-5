package cj.software.spring.pro5.ch04.deletion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import ch.qos.logback.classic.Logger;

public class DeleteInterfaceTest
{
	private Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(
			this.getClass());

	@Test
	public void deleteCalled()
	{
		GenericXmlApplicationContext lCtx = new GenericXmlApplicationContext(
				"classpath:spring/file-delete-context.xml");

		FileHolderWithIf lFileHolder = (FileHolderWithIf) lCtx.getBean("deleteOnExitIf");
		this.logger.info("loaded bean: {}", lFileHolder.getFilePath());

		lCtx.close();

		this.logger.info("destroy was called: {}", String.valueOf(lFileHolder.isFileDeleted()));
		assertThat(lFileHolder.isFileDeleted()).as("file is deleted").isTrue();
	}

}
