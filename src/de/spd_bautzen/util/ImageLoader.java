package de.spd_bautzen.util;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	private static Image image;
	
	public static Image loadImage(String path) {
		try {
			image = ImageIO.read(ImageLoader.class.getResourceAsStream(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
	
}
