package com.theeditorstudio.ordermanager.parsers;

import com.theeditorstudio.ordermanager.models.OrderModel;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 * Order Parser
 *
 * This class will take a Absolute Filepath of a CSV file and read it's content
 * and parse it then store in the orderModels ArrayList
 */
public class OrderParser {

    private String filename;
    private ArrayList<OrderModel> orderModels = new ArrayList<>();

    public OrderParser(String filename){
        this.filename = filename;
    }

    /**
     * Parse CSV to ArrayList
     */
    public void parse(){
        try {
            Reader in = new FileReader(filename); // Construct file reader
            CSVFormat fmt = CSVFormat.EXCEL.withFirstRecordAsHeader();
            Iterable<CSVRecord> records = fmt.parse(in);
            // Run down the entire table
            for (CSVRecord record : records) {
                OrderModel orderModel = new OrderModel(
                        LocalDate.parse(record.get("Create Date"), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                        record.get("Order ID"),
                        record.get("First Name"),
                        record.get("Last Name"),
                        record.get("Item Name"),
                        Integer.valueOf(record.get("Quantity")),
                        Double.valueOf(record.get("Item Price")));
                orderModels.add(orderModel);
            }
        } catch (IOException|IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null,
                    "Error While Processing DB Data:\n" + ex.getMessage(),"Error",ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public ArrayList<OrderModel> getOrderModels(){
        return orderModels;
    }

}
