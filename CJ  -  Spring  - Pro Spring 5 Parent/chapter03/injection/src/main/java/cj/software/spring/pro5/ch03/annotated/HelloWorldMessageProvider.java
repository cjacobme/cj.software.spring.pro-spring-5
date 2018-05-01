package cj.software.spring.pro5.ch03.annotated;

import org.springframework.stereotype.Component;

import cj.software.spring.pro5.ch02.hello.decoupled.MessageProvider;

@Component("provider")
public class HelloWorldMessageProvider
		implements
		MessageProvider
{

	@Override
	public String getMessage()
	{
		return "Hello to the World";
	}

}
