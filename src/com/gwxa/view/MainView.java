package com.gwxa.view;

import java.nio.channels.AcceptPendingException;

import com.gwxa.base.constant.SystemConstant;
import com.gwxa.base.resources.Resources;
import com.gwxa.controller.SysUserController;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainView extends Application {

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
		pane.setLayoutX(5);
		pane.setLayoutY(5);
		pane.setMinSize(850, 500);
		pane.setBackground(new Background(new BackgroundImage(Resources.getImage(SystemConstant.PIC_MAINBG), null, null, null, null)));

		Button btn_user = new Button();
		btn_user.setBackground(new Background(new BackgroundImage(Resources.getImage(SystemConstant.PIC_ACCOUNT), null, null, null, null)));
		btn_user.setLayoutX(204.0);
		btn_user.setLayoutY(226.0);
		btn_user.setMinSize(95, 145);

		btn_user.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			btn_user.setEffect(new DropShadow());
		});

		btn_user.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			btn_user.setEffect(null);
		});

		btn_user.setOnAction((ActionEvent e) -> {
		});

		Button btn_area = new Button();
		btn_area.setBackground(new Background(new BackgroundImage(Resources.getImage(SystemConstant.PIC_AREA), null, null, null, null)));
		btn_area.setLayoutX(386.0);
		btn_area.setLayoutY(226.0);
		btn_area.setMinSize(95, 145);

		btn_area.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			btn_area.setEffect(new DropShadow());
		});

		btn_area.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			btn_area.setEffect(null);
		});

		btn_area.setOnAction((ActionEvent e) -> {
		});

		Button btn_organ = new Button();
		btn_organ.setBackground(new Background(new BackgroundImage(Resources.getImage(SystemConstant.PIC_ORGAN), null, null, null, null)));
		btn_organ.setLayoutX(558.0);
		btn_organ.setLayoutY(226.0);
		btn_organ.setMinSize(95, 145);

		btn_organ.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			btn_organ.setEffect(new DropShadow());
		});

		btn_organ.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			btn_organ.setEffect(null);
		});

		btn_organ.setOnAction((ActionEvent e) -> {
		});

		pane.getChildren().add(btn_user);
		pane.getChildren().add(btn_area);
		pane.getChildren().add(btn_organ);
		anPane.getChildren().add(pane);

		stage.setTitle(SystemConstant.MAIN_TITLE);
		stage.getIcons().add(Resources.getImage(SystemConstant.PIC_LOGIN_LOGO));
		Scene scene = new Scene(anPane, 850, 500);
		stage.resizableProperty().setValue(Boolean.FALSE);
		stage.setScene(scene);
		stage.show();
	}
}
