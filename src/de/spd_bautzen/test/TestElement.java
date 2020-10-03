package de.spd_bautzen.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import de.spd_bautzen.Element;
import de.spd_bautzen.ElementType;

class TestElement {

	@Test
	public void ELEMENT_element_null() {
		boolean thrown = false;
		try {
			@SuppressWarnings("unused")
			Element e = new Element(null);
		} catch (Exception ex) {
			if (ex.getClass() == NullPointerException.class) {
				thrown = true;
			}
		}
		assertTrue(thrown, "null argument in constructor did not throw nullpointer exception");
	}

	@Test
	public void ELEMENT_inv_test() {
		Element e = new Element(ElementType.IMAGE);
		assertTrue(e.type != null, "elements type is null");
		assertTrue(e.getAttributes() != null, "elements attributes are null");
	}

	@Test
	public void ELEMENT_getAttributeValue() {
		Element e = new Element(ElementType.IMAGE);
		e.setAttribute("wasser", "nass");
		boolean thrown = false;
		try {
			e.getAttribute(null);
		}catch(Exception ex) {
			if(ex.getClass() == NullPointerException.class) {
				thrown = true;
			}
		}
		assertTrue(thrown, "null argument in getAttributeValue did not throw nullpointer exception");
		try {
			e.getAttribute("");
		}catch(Exception ex) {
			if(ex.getClass() == NullPointerException.class) {
				thrown = true;
			}
		}
		assertTrue(thrown, "empty string in getAttributeValue did not throw nullpointer exception");
		assertTrue(e.getAttribute("was") == null, "wrong return value when element does not have attribute");
		assertTrue(e.getAttribute("wasser").equals("nass"), "wrong return value when element does have attribute");
		
	}

}