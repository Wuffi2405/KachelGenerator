package de.spd_bautzen;

import java.util.HashMap;
import java.util.Map;

public class Element {
	
	public ElementType type;
	private Map<String, String> attributes;
	
	public Element(ElementType type) {
		if(type == null)
			throw new NullPointerException();
		this.type = type;
		attributes = new HashMap<String, String>();
	}
	
	public String getAttribute(String key) {
		if(key == null || key.isEmpty())
			throw new NullPointerException();
		return attributes.get(key);
	}
	
	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttribute(String key, String value) {
		attributes.put(key, value);
	}
	
}
