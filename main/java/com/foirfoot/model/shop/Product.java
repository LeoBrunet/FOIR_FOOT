package com.foirfoot.model.shop;

public class Product {
     private int id;
     private String nameProduct;
     private String nameCategory;
     private String description;
     private String price;
     private String stock;
     private String imageName;

     public Product(int id,String nameProduct, String nameCategory, String description, String price, String stock,String imageName) {
          this.id = id;
          this.nameProduct = nameProduct;
          this.nameCategory = nameCategory;
          this.description = description;
          this.price = price;
          this.stock = stock;
          this.imageName = imageName;
     }

     public Product(String product_name, String product_category, String product_description, String product_price, String product_stock, String product_image) {
          this.nameProduct = product_name;
          this.nameCategory = product_category;
          this.description=product_description;
          this.price= product_price;
          this.stock= product_stock;
          this.imageName = product_image;
     }

     public String getName(){
          return this.nameProduct;
     }
     public String getNameCategory(){
          return this.nameCategory;
     }
     public String getDescription(){
          return this.description;
     }
     public String getPrice(){
          return this.price;
     }
     public String getStock(){
          return this.stock;
     }
     public String getImage(){
          return this.imageName;
     }
     public void setId(int id) {
          this.id = id;
     }
     public int getId(){
          return this.id;
     }



}