package com.foirfoot.view.shop;

import com.foirfoot.model.Facade;
import com.foirfoot.view.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PaymentTypeController {
    Facade facade = new Facade();
    @FXML
    private Button ValidPayment;

    public void goToSummary() {
        Main.changeScene("shop/orderSummary");
    }
}
