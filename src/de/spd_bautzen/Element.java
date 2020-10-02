package de.spd_bautzen;

import java.util.HashMap;
import java.util.Map;

public class Element {
	
	public ElementType type;
	private Map<String, String> attributes;
	
	public Element(ElementType type) {
		attributes = new HashMap<String, String>();
	}
	
	public String getAttribute(String key) {
		return attributes.get(key);
	}
	
	
	public void setAttribute(String key, String value) {
		attributes.put(key, value);
	}
	
}
