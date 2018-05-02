package cj.software.spring.pro5.ch03.xml;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AllCollectionsTest
{
	@Test
	public void collections()
	{
		GenericXmlApplicationContext lCtx = new GenericXmlApplicationContext();
		try
		{
			lCtx.load("classpath:spring/app-context-xml.xml");
			lCtx.refresh();
			AllCollections lAll = lCtx.getBean("allCollections", AllCollections.class);
			assertThat(lAll).as("root").isNotNull();
			this.assertMap(lAll);
			this.assertProps(lAll);
			this.assertSet(lAll);
			this.assertList(lAll);
		}
		finally
		{
			lCtx.close();
		}
	}

	private void assertMap(AllCollections pContainer)
	{
		Map<String, Object> lMap = pContainer.getMap();
		assertThat(lMap).as("map").isNotNull();
		Set<String> lKeySet = lMap.keySet();
		assertThat(lKeySet).as("set of keys").containsExactlyInAnyOrder("someValue", "someBean");
		Object lSomeValue = lMap.get("someValue");
		assertThat(lSomeValue).as("someValue").isInstanceOf(String.class);
		String lSomeValueString = (String) lSomeValue;
		assertThat(lSomeValueString).as("someValue").isEqualTo("It's Friday and it's weekend");
		Object lSomeBean = lMap.get("someBean");
		assertThat(lSomeBean).as("someBean").isInstanceOf(LyricHolder.class);
		assertThat(lSomeBean.toString()).as("someBean").isEqualTo(
				"LyricHolder['You be the DJ, I'll be the driver']");
	}

	private void assertProps(AllCollections pContainer)
	{
		Properties lProps = pContainer.getProps();
		assertThat(lProps).as("props").isNotNull();
		Set<Object> lKeySet = lProps.keySet();
		assertThat(lKeySet).as("set of keys").containsExactlyInAnyOrder("firstName", "lastName");
		String lFirstName = lProps.getProperty("firstName");
		assertThat(lFirstName).as("first name").isEqualTo("John");
		String lLastName = lProps.getProperty("lastName");
		assertThat(lLastName).as("last name").isEqualTo("Young");
	}

	private void assertSet(AllCollections pContainer)
	{
		Set<?> lSet = pContainer.getSet();
		assertThat(lSet).as("set").isNotNull();
		boolean lStringFound = false;
		boolean lLyricHolderFound = false;
		for (Object bObject : lSet)
		{
			if (bObject instanceof String)
			{
				if ("I can't believe I get to see your face".equals(bObject))
				{
					lStringFound = true;
				}
			}
			else if (bObject instanceof LyricHolder)
			{
				lLyricHolderFound = true;
			}
			else
			{
				fail("unknown type:" + bObject.getClass().getName());
			}
		}
		assertThat(lStringFound).as("string was found").isTrue();
		assertThat(lLyricHolderFound).as("lyric holder found").isTrue();
	}

	private void assertList(AllCollections pContainer)
	{
		List<?> lList = pContainer.getList();
		assertThat(lList).as("list").isNotNull();
		Object lFirst = lList.get(0);
		assertThat(lFirst).as("1st entry").isInstanceOf(String.class);
		assertThat((String) lFirst).as("1st entry").isEqualTo(
				"You've been working and I've been waiting");
		Object lSecond = lList.get(1);
		assertThat(lSecond).as("2nd entry").isInstanceOf(LyricHolder.class);
	}
}
