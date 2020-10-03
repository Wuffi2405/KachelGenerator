package de.spd_bautzen.test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import de.spd_bautzen.Element;
import de.spd_bautzen.ElementType;
import de.spd_bautzen.Generator;

class TestGenerator {

	@Test
	void GENERATOR_generate() {
		Generator g = new Generator();
		boolean thrown = false;
		try {
			g.generate(null);
		} catch (Exception ex) {
			if (ex.getClass() == NullPointerException.class) {
				thrown = true;
			}
		}
		assertTrue(thrown, "null argument in generate did not throw nullpointer exception");
		try {
			g.generate(new ArrayList<Element>());
		} catch (Exception ex) {
			if (ex.getClass() == NullPointerException.class) {
				thrown = true;
			}
		}
		assertTrue(thrown, "empty list in generate did not throw nullpointer exception");
		ArrayList<Element> es = new ArrayList<Element>();
		Element e = new Element(ElementType.IMAGE);
		es.add(e);
		g.generate(es);
		
		assertTrue(g.getImage() != null, "getImage should return image");
	}
}
