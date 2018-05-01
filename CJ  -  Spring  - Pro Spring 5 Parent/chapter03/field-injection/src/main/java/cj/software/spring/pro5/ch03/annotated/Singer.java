package cj.software.spring.pro5.ch03.annotated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Singer
{
	@Autowired
	private Inspiration inspiration;

	public void sing()
	{
		System.out.println(this.inspiration.getLyric());
	}
}
