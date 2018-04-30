package cj.software.spring.pro5.ch02.hello.decoupled;

public class SystemOutMessageRenderer
		implements
		MessageRenderer
{
	private MessageProvider provider;

	@Override
	public void render()
	{
		if (this.provider == null)
		{
			throw new IllegalStateException("no message provider");
		}
		String lMessage = this.provider.getMessage();
		System.out.println(lMessage);
	}

	@Override
	public void setMessageProvider(MessageProvider pMessageProvider)
	{
		this.provider = pMessageProvider;
	}

	@Override
	public MessageProvider getMessasgeProvider()
	{
		return this.provider;
	}

}
