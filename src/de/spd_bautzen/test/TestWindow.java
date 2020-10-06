package de.spd_bautzen.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import de.spd_bautzen.Window;

class TestWindow {

	@Test
	void WINDOW_setPreviewElements_null() {
		Window window = new Window();
		boolean thrown = false;
		try {
			window.setPreviewElements(null);
		} catch (Exception e) {
			if (e.getClass() == NullPointerException.class) {
				thrown = true;
			}
		}
		assertTrue(thrown, "setPreviewElements did not throw nullpointer exception");
	}

}
