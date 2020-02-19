package TwentyFourty8;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML
    private ResourceBundle resources;
    
    @FXML
    private URL location;

    @FXML
    private Pane mainMenu;

    @FXML
    private Button playButton;

    
    @FXML
    void startGame(MouseEvent event) {
        Parent root = null;
        FXMLLoader root1 = null;
        root1 = new FXMLLoader(getClass().getResource("PEX2048FXML.fxml"));
        try {
            root = (Parent) root1.load();
        } catch (IOException ex) {
            
        }
        System.out.println("FXML changed to: " + root);

        Scene sc = new Scene(root);
        Stage st = new Stage();
        st.setTitle("Undertale 2048");
        st.setScene(sc);
        st.show();
        mainMenu.getScene().getWindow().hide();
    }

    @FXML
    void initialize() {
        assert mainMenu != null : "fx:id=\"mainMenu\" was not injected: check your FXML file 'MainMenu.fxml'.";
        assert playButton != null : "fx:id=\"playButton\" was not injected: check your FXML file 'MainMenu.fxml'.";

    }
}


