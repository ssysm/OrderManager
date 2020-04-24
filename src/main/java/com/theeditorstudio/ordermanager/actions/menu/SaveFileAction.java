package com.theeditorstudio.ordermanager.actions.menu;

import com.theeditorstudio.ordermanager.OrderManager;
import com.theeditorstudio.ordermanager.parsers.OrderSerializer;
import com.theeditorstudio.ordermanager.utils.SaveFileChooser;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Save DB Event Action
 *
 * This action listen will fire after the user press the
 * 'Save Database' Button from menu.
 */
public class SaveFileAction implements ActionListener {

    /**
     * Button press trigger
     * @param e Action Event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Set File Chooser
        SaveFileChooser fileChooser = new SaveFileChooser();
        fileChooser.setSelectedFile(OrderManager.currentFile);
        fileChooser.setFileFilter(new FileNameExtensionFilter("*.csv","csv"));
        fileChooser.setApproveButtonMnemonic(KeyEvent.VK_S);
        fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooser.setDialogTitle("Save CSV Database to");
        int status = fileChooser.showSaveDialog(OrderManager.frame);
        if(status != JFileChooser.APPROVE_OPTION) {
            showMessageDialog(null, "User Canceled to Save DB File!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        File saveFileLocation = fileChooser.getSelectedFile();
        // Serialize Table back to CSV File
        OrderSerializer serializer = new OrderSerializer(saveFileLocation);
        serializer.serialize();
        // !!!SET GLOBAL STATUS FLAG!!!
        OrderManager.isModified = false;
    }
}
