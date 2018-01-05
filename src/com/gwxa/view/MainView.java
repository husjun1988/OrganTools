package com.gwxa.view;


import com.gwxa.base.constant.SystemConstant;
import com.gwxa.base.resources.Sources;
import com.gwxa.base.support.BaseView;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainView extends BaseView {

	@Override
	public void start(Stage stage) {
		initAndDisplayUI(stage);
	}

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * 初始化界面
	 * */
	public void initAndDisplayUI(Stage stage) {
		AnchorPane anPane = new AnchorPane();

		Pane pane = new Pane();
		pane.setMinSize(850, 500);
		pane.setBackground(new Background(new BackgroundImage(Sources.getImage(SystemConstant.PIC_MAINBG), null, null, null, null)));

		Button btn_user = new Button();
		btn_user.setBackground(new Background(new BackgroundImage(Sources.getImage(SystemConstant.PIC_ACCOUNT), null, null, null, null)));
		btn_user.setCursor(Cursor.HAND);
		btn_user.setLayoutX(204.0);
		btn_user.setLayoutY(226.0);
		btn_user.setMinSize(95, 145);

		btn_user.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			btn_user.setBackground(new Background(new BackgroundImage(Sources.getImage(SystemConstant.PIC_ACCOUNT_HOVER), null, null, null, null)));
		});

		btn_user.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			btn_user.setBackground(new Background(new BackgroundImage(Sources.getImage(SystemConstant.PIC_ACCOUNT), null, null, null, null)));
		});

		btn_user.setOnAction((ActionEvent e) -> {
			Platform.runLater(new Runnable() {
			    public void run() {
			        new UserView().start(new Stage());
			    }
			});
		});

		Button btn_area = new Button();
		btn_area.setBackground(new Background(new BackgroundImage(Sources.getImage(SystemConstant.PIC_AREA), null, null, null, null)));
		btn_area.setCursor(Cursor.HAND);
		btn_area.setLayoutX(386.0);
		btn_area.setLayoutY(226.0);
		btn_area.setMinSize(95, 145);

		btn_area.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			btn_area.setBackground(new Background(new BackgroundImage(Sources.getImage(SystemConstant.PIC_AREA_HOVER), null, null, null, null)));
		});

		btn_area.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			btn_area.setBackground(new Background(new BackgroundImage(Sources.getImage(SystemConstant.PIC_AREA), null, null, null, null)));
		});

		btn_area.setOnAction((ActionEvent e) -> {
		});

		Button btn_organ = new Button();
		btn_organ.setBackground(new Background(new BackgroundImage(Sources.getImage(SystemConstant.PIC_ORGAN), null, null, null, null)));
		btn_organ.setCursor(Cursor.HAND);
		btn_organ.setLayoutX(558.0);
		btn_organ.setLayoutY(226.0);
		btn_organ.setMinSize(95, 145);

		btn_organ.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			btn_organ.setBackground(new Background(new BackgroundImage(Sources.getImage(SystemConstant.PIC_ORGAN_HOVER), null, null, null, null)));
		});

		btn_organ.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			btn_organ.setBackground(new Background(new BackgroundImage(Sources.getImage(SystemConstant.PIC_ORGAN), null, null, null, null)));
		});

		btn_organ.setOnAction((ActionEvent e) -> {
		});

		pane.getChildren().add(btn_user);
		pane.getChildren().add(btn_area);
		pane.getChildren().add(btn_organ);
		anPane.getChildren().add(pane);

		stage.setTitle(SystemConstant.MAIN_TITLE);
		//stage.getIcons().add(Sources.getImage(SystemConstant.PIC_LOGIN_LOGO));
		Scene scene = new Scene(anPane, 840, 490);
		stage.resizableProperty().setValue(Boolean.FALSE);
		setCenter(stage, 840, 490);
		stage.setScene(scene);
		stage.show();
	}
}
