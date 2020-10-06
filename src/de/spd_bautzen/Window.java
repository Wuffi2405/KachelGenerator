package de.spd_bautzen;

import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Window {

	public JFrame frame;
	private JFileChooser fileChooser;
	private Preview preview;
	private LoadInterpreter loadInterpreter;

	public Window() {

	}

	public void setPreviewElements(List<Element> elements) {
		if (elements == null)
			throw new NullPointerException();
	}

}