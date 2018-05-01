package cj.software.spring.pro5.ch03.annotated;

import org.springframework.context.support.GenericXmlApplicationContext;

import cj.software.spring.pro5.ch02.hello.decoupled.MessageRenderer;

public class DeclareSpringComponents
{
	public static void main(String[] pArgs)
	{
		GenericXmlApplicationContext lCtx = new GenericXmlApplicationContext();
		try
		{
			lCtx.load("classpath:spring/app-context-annotation.xml");
			lCtx.refresh();
			MessageRenderer lRenderer = lCtx.getBean("renderer", MessageRenderer.class);
			lRenderer.render();
			System.out.println(lRenderer.getClass().getName());
			System.out.println(lRenderer.getMessasgeProvider().getClass().getName());
		}
		finally
		{
			lCtx.close();
		}
	}
}
