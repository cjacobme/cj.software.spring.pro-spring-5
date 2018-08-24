package cj.software.spring.pro5.ch04.lifecycle;

import javax.annotation.PostConstruct;

public class SingerJsr250
		extends Singer
{
	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void checkValues()
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
