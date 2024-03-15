package org.library.controller.Table_Row;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import org.library.bo.BorrowBookService;
import org.library.bo.ServiceFactor;
import org.library.controller.BorrowBookPageFormController;
import org.library.dto.BookDto;

public class BorrowBookRowController {
    public Label Id;
    public Label Title;

    private int index = 0;

    public void setData(String title , int index) {
        Title.setText(title);
        SetId(title);
        this.index = index;
    }

    private final BorrowBookService borrowBookService = (BorrowBookService) ServiceFactor.getBoFactory().getBo(ServiceFactor.BoType.Borrow_Book);

    void SetId(String title){
        BookDto data = borrowBookService.getData(title);
        Id.setText("B0"+data.getId());
    }

    public void deleteBtnOnActhion(ActionEvent actionEvent) {
        BorrowBookPageFormController.borrowBookPageFormController.borrowRows.remove(Title.getText());
        BorrowBookPageFormController.borrowBookPageFormController.LoadTable();
    }


}
