package cj.software.spring.pro5.ch03.annotated;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Inspiration
{
	private String lyric = "I can keep the door cracked open, to let light through";

	public Inspiration(@Value("For all my running, I can understand") String pLyric)
	{
		this.lyric = pLyric;
	}

	public String getLyric()
	{
		return this.lyric;
	}

	public void setLyric(String pLyric)
	{
		this.lyric = pLyric;
	}

}
