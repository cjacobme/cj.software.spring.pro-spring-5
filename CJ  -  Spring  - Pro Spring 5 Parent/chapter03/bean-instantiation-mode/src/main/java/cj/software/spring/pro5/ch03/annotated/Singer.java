package cj.software.spring.pro5.ch03.annotated;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;

public class Singer
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	private String name = "unknown";

	public Singer(@Value("Roger Daltrey") String pName)
	{
		this.name = pName;
	}

	public String getName()
	{
		return this.name;
	}
}
