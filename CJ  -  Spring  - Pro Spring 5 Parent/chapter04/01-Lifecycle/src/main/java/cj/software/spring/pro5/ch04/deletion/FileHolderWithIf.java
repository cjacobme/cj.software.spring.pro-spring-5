package cj.software.spring.pro5.ch04.deletion;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;

import ch.qos.logback.classic.Logger;

public class FileHolderWithIf
		extends FileHolder
		implements
		DisposableBean
{
	private Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(
			this.getClass());

	@Override
	public void destroy() throws Exception
	{
		super.closeMe();
		this.logger.info("file exists: {}", String.valueOf(super.getFile().exists()));
	}

}
