package com.gwxa.view;

import com.gwxa.base.constant.SystemConstant;
import com.gwxa.base.resources.Sources;
import com.gwxa.controller.SysUserController;

import javafx.application.Application;
import javafx.application.Platform;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginView extends Application {

	private Text errorMsg;

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
		pane.setBackground(new Background(new BackgroundImage(Sources.getImage("login/bg.jpg"), null, null, null, null)));

		Label lab_name = new Label();
		lab_name.setBackground(new Background(new BackgroundImage(Sources.getImage("login/user.png"), null, null, null, null)));
		lab_name.setLayoutX(110);
		lab_name.setLayoutY(111);
		lab_name.setMinSize(41, 35);

		Label lab_pwd = new Label();
		lab_pwd.setBackground(new Background(new BackgroundImage(Sources.getImage("login/pwd.png"), null, null, null, null)));
		lab_pwd.setLayoutX(110);
		lab_pwd.setLayoutY(153);
		lab_pwd.setMinSize(41, 35);

		TextField name = new TextField();
		name.setBackground(new Background(new BackgroundImage(Sources.getImage("login/input.png"), null, null, null, null)));
		name.setLayoutX(151);
		name.setLayoutY(111);
		name.setMinSize(195, 35);

		PasswordField pwd = new PasswordField();
		pwd.setBackground(new Background(new BackgroundImage(Sources.getImage("login/input.png"), null, null, null, null)));
		pwd.setLayoutX(151);
		pwd.setLayoutY(153);
		pwd.setMinSize(195, 35);

		errorMsg = new Text();
		errorMsg.setLayoutX(110);
		errorMsg.setLayoutY(207);
		errorMsg.setFill(Color.RED);

		Button btn_login = new Button();
		btn_login.setBackground(new Background(new BackgroundImage(Sources.getImage("login/login.png"), null, null, null, null)));
		btn_login.setLayoutX(110.0);
		btn_login.setLayoutY(218.0);
		btn_login.setMinSize(236, 35);

		btn_login.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			btn_login.setEffect(new DropShadow());
		});

		btn_login.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			btn_login.setEffect(null);
		});

		btn_login.setOnAction((ActionEvent e) -> {
			login(stage, name.getText(), pwd.getText());
		});

		pwd.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.ENTER) {
					login(stage, name.getText(), pwd.getText());
				}
			}
		});

		pane.getChildren().add(lab_name);
		pane.getChildren().add(lab_pwd);
		pane.getChildren().add(name);
		pane.getChildren().add(pwd);
		pane.getChildren().add(errorMsg);
		pane.getChildren().add(btn_login);
		anPane.getChildren().add(pane);

		stage.setTitle(SystemConstant.LOGIN_TITLE);
		stage.getIcons().add(Sources.getImage(SystemConstant.PIC_LOGIN_LOGO));
		Scene scene = new Scene(anPane, 440, 257);
		stage.resizableProperty().setValue(Boolean.FALSE);
		stage.setScene(scene);
		stage.show();
	}


	public void login(Stage stage,String account, String pwd) {
		if(SysUserController.Login(account, pwd)) {
			Platform.runLater(new Runnable() {
			    public void run() {
			    	stage.hide();
			        new MainView().start(new Stage());
			    }
			});
		} else {
			showErrorMsg("登陆失败，账号或密码错误");
		}
	}

	public void showErrorMsg(String msg) {
		errorMsg.setText(msg);
	}
}
