package com.theeditorstudio.ordermanager.parsers;

import com.theeditorstudio.ordermanager.OrderManager;
import com.theeditorstudio.ordermanager.models.OrderModel;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 * Order Serializer
 *
 * This class will take a File object and write current table data
 * to a Excel format CSV File using the .serialize() function
 */
public class OrderSerializer {

    private File file;

    public OrderSerializer(File file){
        if(!file.getName().endsWith(".csv")) {
            this.file = new File(file.toString() + ".csv");
        }else{
            this.file = file;
        }
    }

    /**
     * Serialize Table data to csv
     */
    public void serialize() {
        try {
            final CSVPrinter printer = CSVFormat.EXCEL
                    .withHeader(OrderModel.headers)
                    .print(file, StandardCharsets.UTF_8); // Construct CSV converter
            for(OrderModel order: OrderManager.orderModelArrayList){
                printer.printRecord(
                        order.getOrderID(),
                        order.getFirstName(),
                        order.getLastName(),
                        order.getItemName(),
                        order.getQuantity(),
                        order.getItemPrice(),
                        order.getCreateDate()
                );
            }
            printer.flush();
        } catch (IOException e) { // Exception handler
            JOptionPane.showMessageDialog(null,
                    "Error While Processing DB Data:\n" + e.getMessage(), "Error",ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
