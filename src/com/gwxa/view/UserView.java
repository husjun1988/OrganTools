package com.gwxa.view;

import com.gwxa.base.constant.SystemConstant;
import com.gwxa.base.resources.Sources;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UserView extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		initAndDisplayUI(stage);
	}


	/**
	 * 初始化界面
	 * */
	public void initAndDisplayUI(Stage stage) {
		AnchorPane anPane = new AnchorPane();

		stage.setTitle(SystemConstant.MAIN_TITLE);
		stage.getIcons().add(Sources.getImage(SystemConstant.PIC_LOGIN_LOGO));
		Scene scene = new Scene(anPane, 840, 490);
		stage.resizableProperty().setValue(Boolean.FALSE);
		stage.setScene(scene);
		stage.show();
	}
}
