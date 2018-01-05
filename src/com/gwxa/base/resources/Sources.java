package com.gwxa.base.resources;

import javafx.scene.image.Image;

public class Sources {
	public static Image getImage(String path) {
		return new Image(Sources.class.getResourceAsStream(path));
	}
}
