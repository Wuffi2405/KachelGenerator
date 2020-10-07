package de.spd_bautzen;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Random;

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

	public Image getImage(int x, int y) {
		BufferedImage b = new BufferedImage(x, y, BufferedImage.TYPE_INT_ARGB);

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				b.setRGB(j, i, new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)).getRGB());
			}
		}

		return b;
	}

}
