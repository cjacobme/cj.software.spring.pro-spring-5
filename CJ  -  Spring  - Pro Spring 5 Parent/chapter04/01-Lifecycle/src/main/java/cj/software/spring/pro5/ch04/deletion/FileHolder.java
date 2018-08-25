package cj.software.spring.pro5.ch04.deletion;

import java.io.File;

import org.springframework.beans.factory.InitializingBean;

public class FileHolder
		implements
		InitializingBean
{
	private File file;

	private String filePath;

	private boolean fileDeleted;

	@Override
	public void afterPropertiesSet() throws Exception
	{
		if (this.filePath == null)
		{
			throw new IllegalArgumentException("no filepath set");
		}
		this.file = new File(this.filePath);
		this.file.createNewFile();
		this.fileDeleted = false;
	}

	public void destroy()
	{
		this.fileDeleted = false;
		if (!this.file.delete())
		{
			System.err.println("file " + this.file + " could not be deleted");
		}
		else
		{
			this.fileDeleted = true;
		}
	}

	public String getFilePath()
	{
		return this.filePath;
	}

	public void setFilePath(String pFilePath)
	{
		this.filePath = pFilePath;
	}

	public boolean isFileDeleted()
	{
		return this.fileDeleted;
	}
}
