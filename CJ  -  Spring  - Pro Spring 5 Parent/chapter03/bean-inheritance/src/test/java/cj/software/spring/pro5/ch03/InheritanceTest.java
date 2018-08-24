package cj.software.spring.pro5.ch03;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import cj.software.spring.pro5.ch03.annotated.Singer;

public class InheritanceTest
{
	@Test
	public void inheritProperties()
	{
		try (GenericXmlApplicationContext lCtx = new GenericXmlApplicationContext())
		{
			lCtx.load("classpath:spring/app-context-xml.xml");
			lCtx.refresh();

			Singer lParent = lCtx.getBean("parent", Singer.class);
			Singer lChild = lCtx.getBean("child", Singer.class);
			assertThat(lParent.toString()).as("parent").isEqualTo("Singer[name=John Mayer,age=39]");
			assertThat(lChild.toString()).as("parent").isEqualTo("Singer[name=John Mayer,age=3]");
		}
	}
}
