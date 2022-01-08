package com.foirfoot.view.shop;

import com.foirfoot.model.Facade;
import com.foirfoot.model.shop.Product;
import com.foirfoot.view.Controller;
import com.foirfoot.view.Main;
import exceptions.ClubNotFoundException;
import exceptions.ProductNotFoundException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.sql.SQLIntegrityConstraintViolationException;

public class ProductController extends Controller {
    private Product product;

    Facade facade = new Facade();
    @FXML
    public Label productName;
    @FXML
    public Label productDesc;
    @FXML
    public Label productPrice;

    @FXML
    public ImageView pictureProduct;
    /*@FXML
    public Button addToBasket;*/

    @FXML
    public void initialize() {
        int price = this.product.getPrice();
        productName.setText(this.product.getName());
        productDesc.setText(this.product.getDescription());
        productPrice.setText(price + "$");
        setProductImage(Main.downloadImage(product.getImageName(), product.getImageIS()));

        //this.addToBasket.setOnMouseClicked(mouseEvent -> this.addProductToBasket(product));


    }
    public void setProductImage(Image productImage) {
        this.pictureProduct.setImage(productImage);
    }

    public void goToShop() {
        try {
            Main.changeScene("shop/homeShopClub", new HomeShopClubController(), new Object[]{facade.getClub(product.getClubId())});
        } catch (ClubNotFoundException | ProductNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addProductToBasket(Product product) {


        Main.connectedUser.getBasket().addProduct(product);
        try {
            facade.addProduct(Main.connectedUser.getBasket(), product);
        } catch (SQLIntegrityConstraintViolationException | ProductNotFoundException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void setParameter(Object[] params) {
        this.product = (Product) params[0];
    }
}
