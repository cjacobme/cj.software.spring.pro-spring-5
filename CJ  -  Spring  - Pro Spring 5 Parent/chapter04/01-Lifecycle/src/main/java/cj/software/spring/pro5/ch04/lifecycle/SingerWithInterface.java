package cj.software.spring.pro5.ch04.lifecycle;

import org.springframework.beans.factory.InitializingBean;

public class SingerWithInterface
		extends Singer
		implements
		InitializingBean
{
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPropertiesSet() throws Exception
	{
		if (super.getName() == null)
		{
			super.setName(Singer.DEFAULT_NAME);
		}
		if (super.getAge() == Integer.MIN_VALUE)
		{
			throw new IllegalStateException("you must set the property \"age\"");
		}
	}

}
