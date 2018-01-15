package com.gwxa.view;

import java.util.List;

import com.gwxa.base.constant.SystemConstant;
import com.gwxa.base.resources.Sources;
import com.gwxa.base.support.BaseView;
import com.gwxa.base.utils.Paramater;
import com.gwxa.controller.SysUserController;
import com.gwxa.model.SysUser;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class UserView extends BaseView {
	private Pagination pagination;

	final ObservableList<SysUser> data = FXCollections.observableArrayList(
	);

	@Override
	public void start(Stage stage) {
		initAndDisplayUI(stage);
	}

	public static void main(String[] args) {
		launch(args);
	}

	public int itemsPerPage() {
        return 1;
    }

    public int rowsPerPage() {
        return 10;
    }

	public VBox createPage(int pageIndex) {

		data.addAll(SysUserController.list(new Paramater()));

        int lastIndex = 0;
        int displace = data.size() % rowsPerPage();
        if (displace > 0) {
            lastIndex = data.size() / rowsPerPage();
        } else {
            lastIndex = data.size() / rowsPerPage() - 1;

        }

        VBox box = new VBox(5);
        int page = pageIndex * itemsPerPage();

        for (int i = page; i < page + itemsPerPage(); i++) {
            TableView<SysUser> table = new TableView<SysUser>();
            //table.setMinSize(1024, 525);
            TableColumn<SysUser, String> colAcc = new TableColumn<SysUser, String>("账号");
            colAcc.setCellValueFactory(new PropertyValueFactory<SysUser, String>("zhangh"));
            //colAcc.setMinWidth(30);

            TableColumn<SysUser, String> colName = new TableColumn<SysUser, String>("姓名");
            colName.setCellValueFactory(new PropertyValueFactory<SysUser, String>("xingm"));
            //colName.setMinWidth(120);

            TableColumn<SysUser, String> colType = new TableColumn<SysUser, String>("分类");
            colType.setCellValueFactory(new PropertyValueFactory<SysUser, String>("fenl"));
            //colType.setMinWidth(120);

            TableColumn<SysUser, String> colIsable = new TableColumn<SysUser, String>("是否启用");
            colIsable.setCellValueFactory(new PropertyValueFactory<SysUser, String>("youx"));

            table.getColumns().addAll(colAcc, colName, colType, colIsable);
            if (lastIndex == pageIndex) {
                table.setItems(FXCollections.observableArrayList(data.subList(pageIndex * rowsPerPage(), pageIndex * rowsPerPage() + displace)));
            } else {
                table.setItems(FXCollections.observableArrayList(data.subList(pageIndex * rowsPerPage(), pageIndex * rowsPerPage() + rowsPerPage())));
            }

            box.getChildren().add(table);
        }
        return box;
    }

	/**
	 * 初始化界面
	 * */
	public void initAndDisplayUI(Stage stage) {
		ToolBar toolBar = new ToolBar();
		toolBar.setMinWidth(620);

		Button btn_add = new Button();
		btn_add.setBackground(new Background(new BackgroundImage(Sources.getImage(SystemConstant.BTN_ADD), null, null, null, null)));
		btn_add.setMinSize(63, 30);
		btn_add.setCursor(Cursor.HAND);

		btn_add.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			btn_add.setBackground(new Background(new BackgroundImage(Sources.getImage(SystemConstant.BTN_ADD_HOVER), null, null, null, null)));
		});

		btn_add.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			btn_add.setBackground(new Background(new BackgroundImage(Sources.getImage(SystemConstant.BTN_ADD), null, null, null, null)));
		});

		btn_add.setOnAction((ActionEvent e) -> {
			Platform.runLater(new Runnable() {
			    public void run() {

			    }
			});
		});

		Button btn_edit = new Button();
		btn_edit.setBackground(new Background(new BackgroundImage(Sources.getImage(SystemConstant.BTN_EDIT), null, null, null, null)));
		btn_edit.setMinSize(63, 30);
		btn_edit.setCursor(Cursor.HAND);

		btn_edit.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
			btn_edit.setBackground(new Background(new BackgroundImage(Sources.getImage(SystemConstant.BTN_EDIT_HOVER), null, null, null, null)));
		});

		btn_edit.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
			btn_edit.setBackground(new Background(new BackgroundImage(Sources.getImage(SystemConstant.BTN_EDIT), null, null, null, null)));
		});

		btn_edit.setOnAction((ActionEvent e) -> {
			Platform.runLater(new Runnable() {
			    public void run() {

			    }
			});
		});

		toolBar.getItems().add(btn_add);
		toolBar.getItems().add(btn_edit);

		pagination = new Pagination((data.size() / rowsPerPage() + 1), 0);
        //   pagination = new Pagination(20 , 0);
        //pagination.setStyle("-fx-border-color:red;");
        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                if (pageIndex > data.size() / rowsPerPage() + 1) {
                    return null;
                } else {
                    return createPage(pageIndex);
                }
            }
        });

        AnchorPane anPane = new AnchorPane();
        AnchorPane.setTopAnchor(pagination, 33.0);
        AnchorPane.setRightAnchor(pagination, 0.0);
        AnchorPane.setBottomAnchor(pagination, 10.0);
        AnchorPane.setLeftAnchor(pagination, 0.0);
        anPane.getChildren().add(toolBar);
        anPane.getChildren().addAll(pagination);

		stage.setTitle(SystemConstant.MAIN_TITLE);
		stage.getIcons().add(Sources.getImage(SystemConstant.PIC_LOGIN_LOGO));
		Scene scene = new Scene(anPane, 600, 400);
		stage.resizableProperty().setValue(Boolean.FALSE);
		setCenter(stage, 600, 400);
		stage.setScene(scene);
		stage.show();
	}
}
