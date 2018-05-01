package cj.software.spring.pro5.ch03;

import java.io.Serializable;

public class Song
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	private String title;

	public String getTitle()
	{
		return this.title;
	}

	public void setTitle(String pTitle)
	{
		this.title = pTitle;
	}

}
