package project.model;

import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;

public class Image {

	public static final java.awt.Image BACKGROUND = getImage("background.png");
	public static final java.awt.Image ICON = getImage("icon2.png");

	private static java.awt.Image getImage(String name) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("src/project/res/" + name));
		} catch (IOException e) {
		}
		return image;
	}
}
