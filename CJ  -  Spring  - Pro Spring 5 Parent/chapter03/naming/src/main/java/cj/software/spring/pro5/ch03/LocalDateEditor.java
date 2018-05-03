package cj.software.spring.pro5.ch03;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateEditor
		extends PropertyEditorSupport
{
	private LocalDate parse(String pText)
	{
		LocalDate lResult;
		if (pText != null)
		{
			lResult = LocalDate.parse(pText, DateTimeFormatter.ISO_LOCAL_DATE);
		}
		else
		{
			lResult = null;
		}
		return lResult;
	}

	@Override
	public void setAsText(String pText)
	{
		super.setValue(this.parse(pText));
	}

	@Override
	public String getAsText()
	{
		LocalDate lValue = (LocalDate) super.getValue();
		String lResult;
		if (lValue != null)
		{
			lResult = lValue.format(DateTimeFormatter.ISO_LOCAL_DATE);
		}
		else
		{
			lResult = null;
		}
		return lResult;
	}
}
