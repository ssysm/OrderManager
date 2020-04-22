package com.theeditorstudio.ordermanager.windows.dialogs;

import com.theeditorstudio.ordermanager.OrderManager;
import com.theeditorstudio.ordermanager.models.OrderModel;
import com.theeditorstudio.ordermanager.models.OrderTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SearchResultDialog extends JDialog {
    JTable resultTable;
    JDialog resultDialog;
    JScrollPane resultScrollPane;

    public SearchResultDialog(ArrayList<OrderModel> orders){
        resultDialog = new JDialog(OrderManager.frame, "Client Orders Query Result");
        resultTable = new JTable(new OrderTableModel(orders));
        resultScrollPane = new JScrollPane(resultTable);
        // set table options
        resultTable.setAutoCreateRowSorter(true);
        resultTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // set dialog options
        resultDialog.setSize(700,500);
        resultDialog.setLayout(new BorderLayout());
        resultDialog.add(new JLabel("Total Result: "+orders.size()),BorderLayout.PAGE_START);
        resultDialog.add(resultScrollPane,BorderLayout.CENTER);
        resultDialog.setVisible(true);
        resultDialog.setLocationRelativeTo(OrderManager.frame);
    }

}
