package de.spd_bautzen;

import java.awt.Graphics;
import java.util.Map;
import javax.swing.JPanel;

public class Preview extends JPanel {

	private static final long serialVersionUID = 6867111189994929105L;
	private Map<String, Element> elements;
	private Generator generator;

	public static final int pictureX = 5, pictureY = 25, pictureWidth = Math.min(KachelGenerator.width - 20, KachelGenerator.height - 59), pictureHeight = pictureWidth;

	public Preview(Map<String, Element> elements) {
		if (elements == null)
			throw new NullPointerException();

		generator = new Generator();

		this.elements = elements;
		setLayout(null);
		setBounds(pictureX, pictureY, KachelGenerator.width - 15, pictureHeight + 1);
		setVisible(true);
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

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(generator.getImage(pictureWidth, pictureHeight), 0, 0, null);
	}

}
