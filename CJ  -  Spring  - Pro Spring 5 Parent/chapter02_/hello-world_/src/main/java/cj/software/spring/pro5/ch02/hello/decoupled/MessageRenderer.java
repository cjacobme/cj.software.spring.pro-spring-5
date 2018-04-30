package cj.software.spring.pro5.ch02.hello.decoupled;

public interface MessageRenderer
{
	public void render();

	public void setMessageProvider(MessageProvider pMessageProvider);

	public MessageProvider getMessasgeProvider();
}
