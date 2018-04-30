package cj.software.spring.pro5.ch02.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cj.software.spring.pro5.ch02.hello.decoupled.MessageRenderer;

/**
 * this is to show Spring Dependeny Injection into a simple Hello World. The classical Hello World
 * application is separated into two parts: one for delivering the message and the other to render
 * it. Both will be combined with spring dependency injection.
 */
public class HelloWorldSpringDI
{
	public static void main(String[] pArgs)
	{
		ApplicationContext lCtx = new ClassPathXmlApplicationContext("/spring/app-context.xml");
		try
		{
			MessageRenderer lMessageRenderer = lCtx.getBean("renderer", MessageRenderer.class);
			lMessageRenderer.render();
		}
		finally
		{
			((ClassPathXmlApplicationContext) lCtx).close();
		}
	}
}
