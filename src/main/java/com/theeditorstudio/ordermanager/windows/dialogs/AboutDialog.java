package com.theeditorstudio.ordermanager.windows.dialogs;

import com.theeditorstudio.ordermanager.OrderManager;

import javax.swing.*;
import java.awt.*;

public class AboutDialog {
    JDialog dialog;
    JLabel label;

    private static final String labelHtml = "<html>\n" +
                                            "This is the 2020 quarantine AP CS A Project - Order Manager\n" +
                                            "<br/>\n" +
                                            "Written By: Shengming Yuan\n" +
                                            " <br/>\n" +
                                            " Version: " + OrderManager.class.getPackage().getImplementationVersion() +
                                            " </html>\n";

    public AboutDialog(){
        dialog = new JDialog(OrderManager.frame,"About");
        label = new JLabel(labelHtml);
        dialog.add(label);
        dialog.setSize(300,150);
        dialog.setMinimumSize(new Dimension(300,150));
        dialog.setMaximumSize(new Dimension(300,150));
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(OrderManager.frame);
    }

}
