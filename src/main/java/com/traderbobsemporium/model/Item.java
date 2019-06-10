package main.java.com.traderbobsemporium.model;

import main.java.com.traderbobsemporium.util.Util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * @Author Aidan Stewart
 * @Year 2019
 * Copyright (c)
 * All rights reserved.
 */
public class Item extends DataObject {
    private String imageURL;
    private BigDecimal price;
    private int quantity;
    private ItemType itemType;

    public Item(String name,  int quantity, BigDecimal price, String imageURL, ItemType itemType) {
        super(Util.NEW_ID(), name);
        this.imageURL = imageURL;
        this.price = price;
        this.quantity = quantity;
        this.itemType = itemType;
    }

    public Item (ResultSet resultSet) throws SQLException {
        super(resultSet.getLong("id"), resultSet.getString("name"));
        this.imageURL = resultSet.getString("imageURL");
        this.price = resultSet.getBigDecimal("price");
        this.quantity = resultSet.getInt("quantity");
        this.itemType = ItemType.valueOf(resultSet.getString("itemType"));
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price.setScale(2, RoundingMode.HALF_UP);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPriceString(){
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
        double doublePayment = price.doubleValue();
        return n.format(doublePayment);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name=" + getName() +
                "imageURL=" + imageURL +
                ", price=" + price +
                ", itemType=" + itemType +
                '}';
    }
}