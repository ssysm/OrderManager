package com.theeditorstudio.ordermanager.models;

import com.theeditorstudio.ordermanager.OrderManager;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Order Table Model
 *
 * This class inherits the JTable Table Model and
 * construct a custom table structure.
 */
public class OrderTableModel extends AbstractTableModel {

    ArrayList<OrderModel> orderModelArrayList = new ArrayList<>();

    public OrderTableModel() {
        OrderManager.orderModelArrayList = orderModelArrayList;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (orderModelArrayList.isEmpty()) {
            return Object.class;
        }
        return getValueAt(0, columnIndex).getClass();
    }

    public OrderTableModel(ArrayList<OrderModel> orderModelArrayList){
        this.orderModelArrayList = orderModelArrayList;
    }

    @Override
    public int getRowCount() {
        if(orderModelArrayList == null){
            return 0;
        }else{ return orderModelArrayList.size();}
    }

    @Override
    public int getColumnCount() {
        return OrderModel.headers.length + 2; //+2 for Item Total and shipping est
    }

    @Override
    public String getColumnName(int column) {
        if(column < OrderModel.headers.length){
            return OrderModel.headers[column];
        }else if(column == 7){ // Total Value
            return "Item Total";
        }else if(column == 8){ // EST Shipping
            return "Estimate Shipping Date";
        }else {
            return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0: return orderModelArrayList.get(rowIndex).getOrderID();
            case 1: return orderModelArrayList.get(rowIndex).getFirstName();
            case 2: return orderModelArrayList.get(rowIndex).getLastName();
            case 3: return orderModelArrayList.get(rowIndex).getItemName();
            case 4: return orderModelArrayList.get(rowIndex).getQuantity();
            case 5: return orderModelArrayList.get(rowIndex).getItemPrice();
            case 6: return orderModelArrayList.get(rowIndex).getCreateDate();
            case 7: return orderModelArrayList.get(rowIndex).getItemTotal();
            case 8: return orderModelArrayList.get(rowIndex).getESTShipping();
            default: return null;
        }
    }
}
