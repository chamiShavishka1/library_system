package org.library.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.library.bo.AdminService;
import org.library.bo.MemberService;
import org.library.bo.ServiceFactor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginPageController  implements Initializable {

    public CheckBox AdminCheckBox;

    public CheckBox MemberCheckBox;

    public PasswordField PasswordFild;
    public TextField PasswordTextFild;

    public TextField Username;
    public Button viewPass;

    public void initialize(URL url, ResourceBundle resourceBundle ) {
        PasswordTextFild.setVisible( false );
    }

    Boolean flag = false;
    MemberService memberService = (MemberService) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.Member);
    AdminService adminBo = (AdminService) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.Admin);

    @FXML
    void LoginOnActhion(ActionEvent event) {
        if (MemberCheckBox.isSelected()){
            Member_login();
        } else if (AdminCheckBox.isSelected()) {
            Admin_Login();
        }
        else {
            new Alert(Alert.AlertType.INFORMATION,"Please select Member or Admin").show();
        }


    }

    @FXML
    void RegisterHerebtnOnActhion(MouseEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/forms/RegisterPage.fxml"));
            Stage stage = (Stage) PasswordFild.getScene().getWindow();
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void viewPassOnActhion(ActionEvent event) {
        String Password = PasswordFild.getText();
        String TExtPass = PasswordFild.getText();

        if ( flag == false ){
            PasswordFild.setVisible(false);
            PasswordTextFild.setVisible(true);
            PasswordTextFild.setText(Password);
            flag = true;
        }
        else {
            PasswordFild.setVisible(true);
            PasswordTextFild.setVisible(false);
            PasswordFild.setText(TExtPass);
            flag = false;
        }
    }


    public static String memberUsername = "";

    void Member_login(){
        boolean logined = memberService.Login(Username.getText(), PasswordFild.getText());

        if (logined){
            Parent parent = null;
            try {
                memberUsername = Username.getText();
                parent = FXMLLoader.load( getClass().getResource( "/forms/MainDashboardPage.fxml" ) );
                Stage stage = (Stage) PasswordFild.getScene().getWindow();
                stage.setScene(new Scene(parent));
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            new Alert(Alert.AlertType.INFORMATION,"Worng Data has been input").show();
        }
    }


    public static String Admin_Username = "";

    void Admin_Login(){
        boolean logined = adminBo.getData(Username.getText(), PasswordFild.getText());
        if (logined){
            Parent parent = null;
            try {
                Admin_Username = Username.getText();
                parent = FXMLLoader.load( getClass().getResource( "/forms/admin/MainDashboardPage.fxml" ) );
                Stage stage = (Stage) PasswordFild.getScene().getWindow();
                stage.setScene(new Scene(parent));
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            new Alert(Alert.AlertType.INFORMATION,"Worng Data has been input").show();
        }
    }










}
