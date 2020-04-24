package com.theeditorstudio.ordermanager.models;

import com.theeditorstudio.ordermanager.interfaces.IOrder;

import java.time.LocalDate;

/**
 * Order Class
 */
public class OrderModel implements IOrder {
    private LocalDate createDate;
    private String orderID;
    private String firstName;
    private String lastName;
    private Integer quantity;
    private Double itemPrice;

    private String itemName;

    public static final String[] headers = {"Order ID","First Name","Last Name","Item Name","Quantity","Item Price","Create Date"};

    public OrderModel(LocalDate createDate, String orderID, String firstName, String lastName, String itemName, Integer quantity, Double itemPrice) {
        this.createDate = createDate;
        this.orderID = orderID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.quantity = quantity;
        this.itemPrice = itemPrice;
        this.itemName = itemName;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemTotal(){
        return itemPrice * quantity;
    }

    /**
     * Project settings, est around 2 weeks
     * @return LocalDate
     */
    public LocalDate getESTShipping(){ return createDate.plusWeeks(2); }

    @Override
    public String toString() {
        return orderID + '|' + firstName + '|' + lastName + '|' + itemName +
                '|' + itemPrice + '|' + quantity + '|' + createDate + "|T:" + getItemTotal();
    }
}
