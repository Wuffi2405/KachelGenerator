package de.spd_bautzen;

import java.awt.Toolkit;

public class KachelGenerator {

	public static int width = Toolkit.getDefaultToolkit().getScreenSize().width / 3, height = Toolkit.getDefaultToolkit().getScreenSize().height / 3;

	public static void main(String[] args) {
		new Window(width, height);
	}
}
