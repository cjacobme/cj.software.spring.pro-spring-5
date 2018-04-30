package cj.software.spring.pro5.ch02.hello.annotated;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cj.software.spring.pro5.ch02.hello.decoupled.MessageRenderer;

public class HelloWorldSpringAnnotated
{
	public static void main(String[] pArgs)
	{
		ApplicationContext lCtx = new AnnotationConfigApplicationContext(
				HelloWorldConfiguration.class);
		try
		{
			MessageRenderer lRenderer = lCtx.getBean("renderer", MessageRenderer.class);
			lRenderer.render();
		}
		finally
		{
			((AnnotationConfigApplicationContext) lCtx).close();
		}
	}
}
