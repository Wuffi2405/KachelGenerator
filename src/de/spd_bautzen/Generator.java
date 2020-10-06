package de.spd_bautzen;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;

public class Generator {

	private BufferedImage image;
	private List<Element> elements;

	public Generator() {

	}

	public void generate(List<Element> elements) {
		if (elements == null)
			throw new NullPointerException();

		this.elements = elements;

		image = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
	}

	public Image getImage() {
		return image;
	}

}
