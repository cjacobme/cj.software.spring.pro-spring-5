package cj.software.spring.pro5.ch03.annotated;

import org.springframework.context.support.GenericXmlApplicationContext;

public class FieldInjection
{
	public static void main(String[] pArgs)
	{
		GenericXmlApplicationContext lCtx = new GenericXmlApplicationContext(
				"classpath:spring/app-context.xml");
		try
		{
			// lCtx.refresh();
			Singer lSingerBean = lCtx.getBean(Singer.class);
			lSingerBean.sing();
		}
		finally
		{
			lCtx.close();
		}
	}
}
