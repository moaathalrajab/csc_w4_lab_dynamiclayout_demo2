package org.example.demo145435;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ListItemController implements Initializable {

        @FXML
        private Label coursecode;

        @FXML
        private ImageView courseimageurl;

        @FXML
        private Label coursetitle;

        @FXML
        private Button deleteID;

        @FXML
        private Button expandID;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setData(Course c){
        courseimageurl.setImage(new Image(c.getIconURL()));
        coursetitle.setText(c.getCourseTitle());
        coursecode.setText(c.getCourseCode());

    }
}