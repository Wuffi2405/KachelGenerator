package de.spd_bautzen;

import java.awt.Font;
import java.awt.Image;

import de.spd_bautzen.util.ImageLoader;

public abstract class Kachel {
	
	 private Image background;
	 private Font font;
	 private String title;
	 
	 public Kachel() {
		 background = ImageLoader.loadImage("/de/spd_bautzen/background/standard.png");
	 }
	 
	 public void setBackground(Image bg) {
		 this.background = bg;		 
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Image getBackground() {
		return background;
	}
	
}
