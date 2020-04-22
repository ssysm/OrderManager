package com.theeditorstudio.ordermanager.interfaces;

import java.time.LocalDate;

/**
 * The Order Interface
 *
 * This interface define the Order Data Model
 */
public interface IOrder {
    LocalDate createDate = null;
    String orderID = "";
    String firstName = "";
    String lastName = "";
    String itemName = "";
    Integer quantity = 0;
    Double itemPrice = 0.00;
}
