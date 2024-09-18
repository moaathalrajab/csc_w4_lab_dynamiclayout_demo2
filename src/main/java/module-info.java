module org.example.csc_w4_lab_dynamiclayout_demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.csc_w4_lab_dynamiclayout_demo to javafx.fxml;
    exports org.example.csc_w4_lab_dynamiclayout_demo;
}