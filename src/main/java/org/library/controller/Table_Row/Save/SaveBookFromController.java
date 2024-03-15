package org.library.controller.Table_Row.Save;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.library.bo.ManageBookService;
import org.library.bo.ServiceFactor;
import org.library.controller.AdminController.ManageBookFormController;
import org.library.dto.BookDto;
import org.library.util.Validation;

public class SaveBookFromController {
    @FXML
    private TextField Genre;

    @FXML
    private TextField autor;

    @FXML
    private TextField dis;

    @FXML
    private TextField title;

    @FXML
    void saveBtnOnActhion(ActionEvent event) {
        if (Validation.isValidAddress(this.Genre.getText()) && Validation.isValidName(autor.getText()) && Validation.validateBookTitle(title.getText())){
            ManageBookService manageBookService = (ManageBookService) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.Manage_Book);
            int yes = manageBookService.Save(new BookDto(0, title.getText(), autor.getText(), dis.getText(), Genre.getText(), "Yes"));
            if (yes > 0){
                title.setText("");
                autor.setText("");
                dis.setText("");
                Genre.setText("");
                new Alert(Alert.AlertType.INFORMATION, "Saved").show();
                ManageBookFormController manageBookFormController = new ManageBookFormController();
                manageBookFormController.initialize(null,null);
            }
        }
        else {
            new Alert(Alert.AlertType.ERROR, "Invalid Input").show();
        }
    }

}
