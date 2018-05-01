package cj.software.spring.pro5.ch03.annotated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cj.software.spring.pro5.ch02.hello.decoupled.MessageProvider;
import cj.software.spring.pro5.ch02.hello.decoupled.MessageRenderer;

@Service("renderer")
public class SystemOutMessageRenderer
		implements
		MessageRenderer
{
	private MessageProvider messageProvider;

	@Override
	public void render()
	{
		if (this.messageProvider == null)
		{
			throw new IllegalStateException("no messageProvider");
		}
		String lText = this.messageProvider.getMessage();
		System.out.println(lText);
	}

	@Override
	@Autowired
	public void setMessageProvider(MessageProvider pMessageProvider)
	{
		this.messageProvider = pMessageProvider;
	}

	@Override
	public MessageProvider getMessasgeProvider()
	{
		return this.messageProvider;
	}

}
