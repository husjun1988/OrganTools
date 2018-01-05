package com.gwxa.base.support;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class BaseView extends Application {

	@Override
	public void start(Stage arg0) throws Exception {

	}

	/**
	 * 设置在屏幕正中
	 * */
	public void setCenter(Stage stage, double x, double y) {
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();
		stage.setX(bounds.getWidth()/2-x/2);
		stage.setY(bounds.getHeight()/2-y/2);
	}
}
