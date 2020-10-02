package de.spd_bautzen.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import de.spd_bautzen.Element;
import de.spd_bautzen.ElementType;
import de.spd_bautzen.Preview;

class TestPreview {
	Preview preview;
	
	@Test
	void PREVIEW_preview_null() {
		boolean thrown = false;
		try {
			@SuppressWarnings("unused")
			Preview p = new Preview(null);
		} catch (Exception e) {
			if (e.getClass() == NullPointerException.class)
				thrown = true;
		}
		assertTrue(thrown, "nullpointer in constructor argument should throw nullpointer exception");
	}

	@Test
	void PREVIEW_updateElement_good() {
		HashMap<String, Element> elements = new HashMap<String, Element>();
		Element e = new Element(ElementType.IMAGE);
		e.setAttribute("x", "100");
		e.setAttribute("y", "200");
		elements.put("picture1", e);
		preview = new Preview(elements);
		assertTrue(preview.updateElement("picture1", "x", "200"), "update element failed");
	}

	@Test
	void PREVIEW_updateElement_null() {
		HashMap<String, Element> elements = new HashMap<String, Element>();
		Element e = new Element(ElementType.IMAGE);
		e.setAttribute("x", "100");
		e.setAttribute("y", "200");
		elements.put("picture1", e);
		preview = new Preview(elements);
		assertFalse(preview.updateElement(null, "x", "200"), "update element failed");
		assertFalse(preview.updateElement("picture1", null, "200"), "update element failed");
		assertFalse(preview.updateElement("picture1", "x", null), "update element failed");
	}
	
	@Test
	void PREVIEW_updateElement_invalid() {
		HashMap<String, Element> elements = new HashMap<String, Element>();
		elements.put("picture1", new Element(ElementType.IMAGE));
		preview = new Preview(elements);
		assertFalse(preview.updateElement("picture2", "a", "was"), "update element failed");
		assertFalse(preview.updateElement("picture1", "a", "was"), "update element failed");
		assertFalse(preview.updateElement("picture", "was", "ser"), "update element failed");
	}
	
}
