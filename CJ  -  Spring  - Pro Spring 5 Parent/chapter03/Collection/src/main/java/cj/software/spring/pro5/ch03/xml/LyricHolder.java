package cj.software.spring.pro5.ch03.xml;

import java.io.Serializable;

public class LyricHolder
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	private String value = "'You be the DJ, I'll be the driver'";

	@Override
	public String toString()
	{
		StringBuilder lSB = new StringBuilder("LyricHolder[").append(this.value).append("]");
		String lResult = lSB.toString();
		return lResult;
	}
}
