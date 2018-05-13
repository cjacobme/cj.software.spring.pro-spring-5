package cj.software.spring.pro5.ch03.annotated;

import java.io.Serializable;

public class Guitar
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	public String sing()
	{
		return "Cm Eb Fm Ab Bb";
	}

}
