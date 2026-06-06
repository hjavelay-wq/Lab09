module com.ucv.labt09 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.ucv.labt09 to javafx.fxml;
    exports com.ucv.labt09;
}