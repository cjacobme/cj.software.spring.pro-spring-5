package cj.software.spring.pro5.ch03.xml;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class AllCollections
{
	private Map<String, Object> map;

	private Properties props;

	private Set<?> set;

	private List<?> list;

	public void setList(List<?> list)
	{
		this.list = list;
	}

	public void setSet(Set<?> set)
	{
		this.set = set;
	}

	public void setMap(Map<String, Object> map)
	{
		this.map = map;
	}

	public void setProps(Properties props)
	{
		this.props = props;
	}

	public Map<String, Object> getMap()
	{
		return this.map;
	}

	public Properties getProps()
	{
		return this.props;
	}

	public Set<?> getSet()
	{
		return this.set;
	}

	public List<?> getList()
	{
		return this.list;
	}
}
