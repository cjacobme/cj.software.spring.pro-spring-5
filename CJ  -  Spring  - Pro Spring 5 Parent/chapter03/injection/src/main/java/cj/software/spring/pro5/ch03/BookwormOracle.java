package cj.software.spring.pro5.ch03;

public class BookwormOracle
		implements
		Oracle
{
	@SuppressWarnings("unused")
	private Encyclopedia encyclopedia;

	public void setEncyclopedia(Encyclopedia pEncyclopedia)
	{
		this.encyclopedia = pEncyclopedia;
	}

	@Override
	public String defineMeaningOfLife()
	{
		return "Encyclopedias are a waste of time - go see the world instead";
	}

}
