package org.example.csc_w4_lab_dynamiclayout_demo;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;

public class MainController implements Initializable {

    ObservableList<Course> ls ;
    Stage mainStage;
    @FXML
    private Label welcomeText;
    @FXML
    private VBox listPlace;

    @FXML
    private MenuItem aboutMenu;

    @FXML
    private MenuItem exitBtn;

    @FXML
    private MenuItem openMenuItem;

    @FXML
    void exitApplication(ActionEvent event) {
        System.exit(0);
    }


    @FXML
    void openAboutMenu(ActionEvent event) {

        Stage aboutStage = new Stage();
        aboutStage.setTitle("About window");
        mainStage = (Stage)listPlace.getScene().getWindow();

        // Set modality to block interaction with parent stage
        aboutStage.initModality(Modality.WINDOW_MODAL);
        aboutStage.initOwner(mainStage); // Set parent stage

        VBox layout = new VBox(10);


        Label aboutText= new Label("About");
        aboutText.setPrefHeight(100);
        aboutText.setPrefWidth(100);

        Button closeBtn = new Button("Close");
        closeBtn.setOnAction(e -> aboutStage.close());

        layout.getChildren().addAll(aboutText,closeBtn);
        Scene scene = new Scene(layout, 200, 100);

        aboutStage.setScene(scene);
        aboutStage.showAndWait();
    }

    @FXML
    void openWindow(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        mainStage = (Stage)listPlace.getScene().getWindow();

        // Set filters for file types if needed
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );

        // Show open dialog
        File selectedFile = fileChooser.showOpenDialog(mainStage);

        if (selectedFile != null) {
           ls.addAll( readCoursesFromFile(selectedFile) );
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       ls= getCourses();
       System.out.println(ls.toString());


        for (int i=0; i<ls.size(); i++){
            FXMLLoader fxmlLoader= new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("list_item.fxml"));
            try{
                HBox root = fxmlLoader.load();

                ListItemController itmC= (ListItemController)fxmlLoader.getController();
                itmC.setData(ls.get(i));
                listPlace.getChildren().add(root);
            }catch (IOException e){System.err.println(e);}

        }

        ls.addListener(new ListChangeListener<Course>() {
            @Override
            public void onChanged(Change<? extends Course> change) {
                for (int i=0; i<ls.size(); i++){
                    FXMLLoader fxmlLoader= new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("list_item.fxml"));
                    try{
                        HBox root = fxmlLoader.load();

                        ListItemController itmC= (ListItemController)fxmlLoader.getController();
                        itmC.setData(ls.get(i));
                        listPlace.getChildren().add(root);
                    }catch (IOException e){System.err.println(e);}

                }
            }
        }


        );


        openMenuItem.setText(openMenuItem.getText()+"\t \t");
        openMenuItem
        .setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.ALT_DOWN));

        ImageView igv = new ImageView(new Image(getClass()
                .getResource("/imgs/open.png").toString()));
        igv.setFitWidth(16);
        igv.setFitHeight(16);
        openMenuItem.setGraphic(igv);
    }


    private ObservableList<Course> getCourses(){
        ls= FXCollections.<Course>observableArrayList();

        Course c1= new Course(getClass().getResource("/imgs/face.png").toString(),
                "CSC311", "Advanced Programming");
        Course c2= new Course(getClass().getResource("/imgs/face.png").toString(),
                "CSC325", "Advanced Programming");
        Course c3= new Course(getClass().getResource("/imgs/face.png").toString(),
                "CSC375", "Advanced Programming");
        ls.add(c1);ls.add(c2);ls.add(c3);
        return ls;

    }

      // write a test for this method in the MainControllerTest class.
    private ObservableList<Course> readCoursesFromFile(File file) {
        ObservableList<Course> courses = FXCollections.observableArrayList();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    throw new IllegalArgumentException("Invalid file format");
                }
                String iconUrl = getClass().getResource(parts[2].trim()).toString();
                String courseCode = parts[0];
                String courseTitle = parts[1];
                Course course = new Course(iconUrl, courseCode, courseTitle);
                courses.add(course);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return courses;
    }


}