package cj.software.spring.pro5.ch03.xml;

import java.io.Serializable;

public class InjectSimple
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	private String name;

	private int age;

	private float height;

	private boolean programmer;

	private Long ageInSeconds;

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

	public float getHeight()
	{
		return this.height;
	}

	public void setHeight(float pHeight)
	{
		this.height = pHeight;
	}

	public boolean isProgrammer()
	{
		return this.programmer;
	}

	public void setProgrammer(boolean pProgrammer)
	{
		this.programmer = pProgrammer;
	}

	public Long getAgeInSeconds()
	{
		return this.ageInSeconds;
	}

	public void setAgeInSeconds(Long pAgeInSeconds)
	{
		this.ageInSeconds = pAgeInSeconds;
	}

	@Override
	public String toString()
	{
		//@formatter:off
		StringBuilder lSB = new StringBuilder("InjectSimple")
				.append("[name=").append(this.name)
				.append(",age=").append(this.age)
				.append(",age in seconds=").append(this.ageInSeconds)
				.append(",height=").append(this.height)
				.append(",is programmer=").append(isProgrammer())
				.append("]");
		//@formatter:on
		String lResult = lSB.toString();
		return lResult;
	}
}
