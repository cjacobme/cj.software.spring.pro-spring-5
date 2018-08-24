package cj.software.spring.pro5.ch04.lifecycle;

import java.io.Serializable;

public class Singer
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	static final String DEFAULT_NAME = "Eric Clapton";

	private String name;

	private int age = Integer.MIN_VALUE;

	public String getName()
	{
		return this.name;
	}

	public void setName(String pName)
	{
		this.name = pName;
	}

	public int getAge()
	{
		return this.age;
	}

	public void setAge(int pAge)
	{
		this.age = pAge;
	}

	public void init()
	{
		if (this.name == null)
		{
			this.name = DEFAULT_NAME;
		}

		if (this.age <= Integer.MIN_VALUE)
		{
			throw new IllegalArgumentException("you must set property \"age\"");
		}
	}

	@Override
	public String toString()
	{
		StringBuilder lSB = new StringBuilder("Singer [")
				.append("name=")
				.append(this.name)
				.append(", age=")
				.append(this.age)
				.append("]");
		String lResult = lSB.toString();
		return lResult;
	}
}
