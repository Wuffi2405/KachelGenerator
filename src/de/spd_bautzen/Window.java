package de.spd_bautzen;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Window {

	public JFrame frame;
	private JFileChooser fileChooser;
	private Preview preview;
	private LoadInterpreter loadInterpreter;

	static String windowName = "Kachel Generator";

	public Window(int width, int height) {

		JMenuBar menubar = new JMenuBar();
		menubar.setSize(new Dimension(width, 20));

		JMenu file = new JMenu();
		file.setText("Datei");
		file.setSize(width / 4, 20);

		JMenuItem open = new JMenuItem();
		open.setSize(width / 4, 20);
		open.setText("Öffnen");
		open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getModifiers() == 16) {
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.showOpenDialog(null);
					frame.setTitle(windowName + " | " + fileChooser.getSelectedFile().getAbsolutePath());
				}
			}
		});

		JMenuItem save = new JMenuItem();
		save.setSize(width / 4, 20);
		save.setText("Speichern");
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getModifiers() == 16) {
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.showSaveDialog(null);
				}
			}
		});

		file.add(open);
		file.add(save);

		menubar.add(file);

		frame = new JFrame(windowName);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);

		frame.setLayout(null);
		frame.add(menubar);
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					System.exit(0);
				}
			}
		});
		frame.setVisible(true);
	}

	public void setPreviewElements(List<Element> elements) {
		if (elements == null)
			throw new NullPointerException();

	}

}