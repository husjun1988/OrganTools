package com.gwxa.view;

import com.gwxa.base.constant.SystemConstant;
import com.gwxa.base.resources.Resources;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginView extends Application {

	@Override
	public void start(Stage stage) {
		initAndDisplayUI(stage);
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void initAndDisplayUI(Stage stage) {
		AnchorPane anPane = new AnchorPane();

		Pane pane = new Pane();
		pane.setMinSize(453, 267);
		pane.setBackground(new Background(new BackgroundImage(Resources.getImage("login/bg.jpg"), null, null, null, null)));

		Label lab_name = new Label();
		lab_name.setBackground(new Background(new BackgroundImage(Resources.getImage("login/user.png"), null, null, null, null)));
		lab_name.setLayoutX(110);
		lab_name.setLayoutY(111);
		lab_name.setMinSize(41, 35);

		Label lab_pwd = new Label();
		lab_pwd.setBackground(new Background(new BackgroundImage(Resources.getImage("login/pwd.png"), null, null, null, null)));
		lab_pwd.setLayoutX(110);
		lab_pwd.setLayoutY(153);
		lab_pwd.setMinSize(41, 35);

		TextField name = new TextField();
		name.setBackground(new Background(new BackgroundImage(Resources.getImage("login/input.png"), null, null, null, null)));
		name.setLayoutX(151);
		name.setLayoutY(111);
		name.setMinSize(195, 35);

		PasswordField pwd = new PasswordField();
		pwd.setBackground(new Background(new BackgroundImage(Resources.getImage("login/input.png"), null, null, null, null)));
		pwd.setLayoutX(151);
		pwd.setLayoutY(153);
		pwd.setMinSize(195, 35);

		Button btn_login = new Button();
		btn_login.setBackground(new Background(new BackgroundImage(Resources.getImage("login/login.png"), null, null, null, null)));
		btn_login.setLayoutX(110.0);
		btn_login.setLayoutY(198.0);
		btn_login.setMinSize(236, 35);

		btn_login.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			btn_login.setEffect(new DropShadow());
		});

		btn_login.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			btn_login.setEffect(null);
		});

		btn_login.setOnAction((ActionEvent e) -> {
		});

		pwd.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.ENTER) {
				}
			}
		});

		pane.getChildren().add(lab_name);
		pane.getChildren().add(lab_pwd);
		pane.getChildren().add(name);
		pane.getChildren().add(pwd);
		pane.getChildren().add(btn_login);
		anPane.getChildren().add(pane);

		stage.setTitle(SystemConstant.login_title);
		stage.getIcons().add(Resources.getImage("logo.png"));
		Scene scene = new Scene(anPane, 440, 247);
		stage.resizableProperty().setValue(Boolean.FALSE);
		stage.setScene(scene);
		stage.show();
	}
}
