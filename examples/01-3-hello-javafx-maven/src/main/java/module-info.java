module br.edu.idp.cc.poo {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.edu.idp.cc.poo to javafx.fxml;
    exports br.edu.idp.cc.poo;
}
