package cj.software.spring.pro5.ch03.annotated;

import java.io.Serializable;

public class Singer
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	private String name;

	private int age;

	public void setName(String pName)
	{
		this.name = pName;
	}

	public void setAge(int pAge)
	{
		this.age = pAge;
	}

	@Override
	public String toString()
	{
		//@formatter:off
		StringBuilder lSB = new StringBuilder("Singer")
				.append("[name=").append(this.name)
				.append(",age=").append(this.age)
				.append("]");
		//@formatter:on
		String lResult = lSB.toString();
		return lResult;
	}
}
