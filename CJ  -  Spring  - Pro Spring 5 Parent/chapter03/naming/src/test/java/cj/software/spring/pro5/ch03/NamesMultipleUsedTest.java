package cj.software.spring.pro5.ch03;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import ch.qos.logback.classic.Logger;

public class NamesMultipleUsedTest
{
	private static GenericXmlApplicationContext ctx;

	private Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(
			this.getClass());

	@BeforeClass
	public static void loadContext()
	{
		ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-multi-persons.xml");
		ctx.refresh();
	}

	@AfterClass
	public static void closeContext()
	{
		if (ctx != null)
		{
			ctx.close();
		}
	}

	@Test
	public void loadPerson()
	{
		Person lPerson = ctx.getBean("person", Person.class);
		this.assertPerson(lPerson, "Karl", "Durchschnitt", LocalDate.of(2000, 1, 1));
	}

	@Test
	public void loadOtto()
	{
		Person lPerson = ctx.getBean("otto", Person.class);
		this.assertPerson(lPerson, "Otto", "Normalverbraucher", LocalDate.of(1999, 12, 31));
	}

	@Test
	public void loadByType()
	{
		Map<String, Person> lBeansOfType = ctx.getBeansOfType(Person.class);
		Set<String> lKeySet = lBeansOfType.keySet();
		assertThat(lKeySet).as("set of keys").containsExactlyInAnyOrder("person", "otto");
		this.assertPerson(
				lBeansOfType.get("person"),
				"Karl",
				"Durchschnitt",
				LocalDate.of(2000, 1, 1));
		this.assertPerson(
				lBeansOfType.get("otto"),
				"Otto",
				"Normalverbraucher",
				LocalDate.of(1999, 12, 31));
	}

	@Test
	public void loadByAlias()
	{
		Person lPerson = ctx.getBean("karl", Person.class);
		this.assertPerson(lPerson, "Karl", "Durchschnitt", LocalDate.of(2000, 1, 1));
	}

	private void assertPerson(
			Person pPerson,
			String pExpFirstName,
			String pExpLastName,
			LocalDate pExpBirthday)
	{
		assertThat(pPerson).as("loaded person").isNotNull();
		this.logger.info("loaded person is {}", pPerson);
		assertThat(pPerson.getFirstName()).as("firstName").isEqualTo(pExpFirstName);
		assertThat(pPerson.getLastName()).as("lastName").isEqualTo(pExpLastName);
		assertThat(pPerson.getBirthday()).as("birthday").isEqualTo(pExpBirthday);
	}
}
