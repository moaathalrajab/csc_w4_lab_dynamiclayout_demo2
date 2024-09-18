module org.example.demo145435 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.demo145435 to javafx.fxml;
    exports org.example.demo145435;
}