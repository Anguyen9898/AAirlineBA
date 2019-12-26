/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aabairline;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author anguy
 */
public class FXMLHomeController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void bookingBtnHandler(ActionEvent event) throws IOException{
//        Task openTask = createTask();
//        Alert a = new Alert(Alert.AlertType.NONE);
//        a.getButtonTypes().clear();
//        
//        ProgressBar pb = new ProgressBar();
//        a.setGraphic(pb);
//        pb.progressProperty().bind(openTask.progressProperty());
        
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass()
                .getResource("FXMLBooking.fxml"))));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.getIcons().add(new Image(getClass()
                .getResource("images/ticket-book.png").toString()));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner((Stage) ((Node) event.getSource()).getScene().getWindow());
        stage.setFullScreen(true);
        stage.show();        
    }
    
//    public Task createTask(){
//        return new Task() {
//            @Override
//            protected Object call() throws Exception {
//                for (int i = 0; i < 100; i++) {
//                    Thread.sleep(2000);
//                    updateMessage("2000 miliseconds");
//                    updateProgress(i + 1, 100);
//                }
//                return true;
//            }
//        };
//    }
}
