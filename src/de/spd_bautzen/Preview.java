package de.spd_bautzen;

import java.util.Map;

import javafx.scene.image.ImageView;

public class Preview {

	private ImageView imageView;
	private Map<String, Element> elements;
	private Generator generator;

	public Preview(Map<String, Element> elements) {
		if (elements == null)
			throw new NullPointerException();

		this.elements = elements;
		
	}

	public boolean updateElement(String elementName, String attributeName, String value) {
		if (elements.containsKey(elementName)) {
			if (elements.get(elementName).getAttribute(attributeName) != null) {
				if (value != null && !value.isEmpty()) {
					elements.get(elementName).setAttribute(attributeName, value);
					return true;
				}
			}
		}
		return false;
	}

	public void updateImage() {
		
	}

}
