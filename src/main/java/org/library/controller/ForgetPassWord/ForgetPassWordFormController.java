package org.library.controller.ForgetPassWord;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.library.bo.ForgetMailService;
import org.library.bo.ServiceFactor;

import javax.mail.*;

public class ForgetPassWordFormController {

    public static String user;
    public TextField textField;

    private final ForgetMailService forgetMailService = (ForgetMailService) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.forgetPassword);
    public void emailOnActhion(ActionEvent actionEvent) {
        boolean b = forgetMailService.sendEmail(textField.getText(), user);
        if (b) {
            new Alert(Alert.AlertType.CONFIRMATION, "Email Send").show();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/forms/ConfirmEmail.fxml"));
            try {
                Stage stage = (Stage) textField.getScene().getWindow();
                stage.setScene(new javafx.scene.Scene(fxmlLoader.load()));
                stage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else {
            new Alert(Alert.AlertType.ERROR, "Email Not Found").show();
        }
    }
}
