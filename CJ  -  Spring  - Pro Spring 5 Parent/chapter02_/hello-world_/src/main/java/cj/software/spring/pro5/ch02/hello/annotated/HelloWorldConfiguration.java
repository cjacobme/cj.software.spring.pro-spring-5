package cj.software.spring.pro5.ch02.hello.annotated;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cj.software.spring.pro5.ch02.hello.decoupled.HelloWorldMessageProvider;
import cj.software.spring.pro5.ch02.hello.decoupled.MessageProvider;
import cj.software.spring.pro5.ch02.hello.decoupled.MessageRenderer;
import cj.software.spring.pro5.ch02.hello.decoupled.SystemOutMessageRenderer;

@Configuration
public class HelloWorldConfiguration
{
	@Bean
	public MessageProvider provider()
	{
		return new HelloWorldMessageProvider();
	}

	@Bean
	public MessageRenderer renderer()
	{
		MessageRenderer lResult = new SystemOutMessageRenderer();
		lResult.setMessageProvider(this.provider());
		return lResult;
	}
}
