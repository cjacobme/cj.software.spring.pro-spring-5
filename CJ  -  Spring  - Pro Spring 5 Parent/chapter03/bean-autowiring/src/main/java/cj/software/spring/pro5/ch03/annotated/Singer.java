package cj.software.spring.pro5.ch03.annotated;

import java.io.Serializable;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Singer
		implements
		Serializable,
		ApplicationContextAware
{
	private static final long serialVersionUID = 1L;

	private ApplicationContext applicationContext;

	private Guitar guitar;

	public String sing()
	{
		this.guitar = this.applicationContext.getBean("gopher", Guitar.class);
		String lResult = this.guitar.sing();
		return lResult;
	}

	@Override
	public void setApplicationContext(ApplicationContext pApplicationContext) throws BeansException
	{
		this.applicationContext = pApplicationContext;
	}

}
