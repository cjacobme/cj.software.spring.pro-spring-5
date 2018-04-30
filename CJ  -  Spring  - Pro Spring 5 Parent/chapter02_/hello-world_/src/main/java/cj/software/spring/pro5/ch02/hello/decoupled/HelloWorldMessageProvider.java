package cj.software.spring.pro5.ch02.hello.decoupled;

public class HelloWorldMessageProvider
		implements
		MessageProvider
{

	@Override
	public String getMessage()
	{
		return "Hello World";
	}

}
