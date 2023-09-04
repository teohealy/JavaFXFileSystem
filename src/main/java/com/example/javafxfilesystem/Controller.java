package com.example.javafxfilesystem;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label insPathLabel;

    @FXML
    private TextField insPathTextField;

    @FXML
    private Label listFileLabel;

    @FXML
    private ListView<String> listFileListView;

    @FXML
    private Button showFilesButton;

    @FXML
    void initialize() {
        showFilesButton.setOnAction(actionEvent -> showFiles());

    }

    private void showFiles(){
        String path = insPathTextField.getText();
        File directory = new File(path);


        if (directory.isDirectory() && directory.exists()){
            String[] files = directory.list();
            if (files != null){
                listFileListView.getItems().clear();
                listFileListView.getItems().addAll(Arrays.asList(files));
            }
        }else {
            listFileListView.getItems().clear();
            listFileListView.getItems().add("Файлы не найдены. Проверьте значение");
        }
    }

}