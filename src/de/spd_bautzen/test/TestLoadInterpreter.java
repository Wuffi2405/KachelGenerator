package de.spd_bautzen.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import de.spd_bautzen.Element;
import de.spd_bautzen.ElementType;
import de.spd_bautzen.LoadInterpreter;

class TestLoadInterpreter {
	
	private LoadInterpreter loadInterpreter;
	Element e1, e2, e3;
	
	@Test
	void testReadXMLNullFile() {
		
		loadInterpreter = new LoadInterpreter();
		
		try{
			loadInterpreter.readXML(null);
			fail("Can't work with null File");
		}catch(NullPointerException e) {
			
		}
		
	}
	
	@Test
	void testReadXMLNoneExistingFile() {
		
		loadInterpreter = new LoadInterpreter();
		
		try{
			loadInterpreter.readXML(new File(""));
			fail("Can't work with null File");
		}catch(NoSuchElementException e) {
			
		}
		
	}
	
	@Test
	void testGetElements() {
		
		loadInterpreter = new LoadInterpreter();
		e1 = new Element(ElementType.TEXT);
		
		try {
			loadInterpreter.getElements();
			fail("List is emtpy");
		}catch(NullPointerException e) {
			
		}
		
		loadInterpreter.elements.add(e1);
		assertTrue("falsche ", loadInterpreter.getElements().size() == 1);
		
	}

}
