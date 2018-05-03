package cj.software.spring.pro5.ch03;

import java.io.Serializable;
import java.time.LocalDate;

public class Person
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	private String firstName;

	private String lastName;

	private LocalDate birthday;

	public String getFirstName()
	{
		return this.firstName;
	}

	public void setFirstName(String pFirstName)
	{
		this.firstName = pFirstName;
	}

	public String getLastName()
	{
		return this.lastName;
	}

	public void setLastName(String pLastName)
	{
		this.lastName = pLastName;
	}

	public LocalDate getBirthday()
	{
		return this.birthday;
	}

	public void setBirthday(LocalDate pBirthday)
	{
		this.birthday = pBirthday;
	}

	@Override
	public String toString()
	{
		//@formatter:off
		StringBuilder lSB = new StringBuilder("Person")
				.append("[firstName=").append(this.firstName)
				.append(",lastName=").append(this.lastName)
				.append(",birthday=").append(this.birthday)
				.append("]");
		//@formatter:on
		String lResult = lSB.toString();
		return lResult;
	}
}
