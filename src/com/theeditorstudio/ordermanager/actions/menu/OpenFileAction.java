package com.theeditorstudio.ordermanager.actions.menu;


import com.theeditorstudio.ordermanager.OrderManager;
import com.theeditorstudio.ordermanager.models.OrderTableModel;
import com.theeditorstudio.ordermanager.parsers.OrderParser;
import com.theeditorstudio.ordermanager.windows.components.StatusComponent;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import static com.theeditorstudio.ordermanager.adapters.MainWindowAdapter.ObjButtons;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Open New File Event Action
 *
 * This action listen will fire after the user press the
 * 'Open Database' Button from menu.
 */
public class OpenFileAction implements ActionListener {

    /**
     * Button press trigger
     * @param e Action Event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if modified flag is set
        if(OrderManager.isModified){
            int PromptResult = JOptionPane.showOptionDialog(OrderManager.frame,
                    "You have modified data that's unsaved.\nAre you sure you want to open a new DB?",
                    "Order Manager", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                    null, ObjButtons, ObjButtons[1]);
            if (PromptResult == JOptionPane.NO_OPTION) {
                return;
            }
        }
        // Set File Chooser
        File file = OrderManager.currentFile;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("*.csv","csv"));
        fileChooser.setSelectedFile(file);
        fileChooser.setApproveButtonMnemonic(KeyEvent.VK_O);
        fileChooser.setDialogType(JFileChooser.FILES_ONLY);
        int status =  fileChooser.showDialog(null,"Open");
        if(status != JFileChooser.APPROVE_OPTION){
            showMessageDialog(null, "User Canceled to Select DB File!","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Parse Selected File
        File selectedFile = fileChooser.getSelectedFile();
        OrderManager.currentFile = selectedFile;
        OrderParser parser = new OrderParser(selectedFile.getAbsolutePath());
        parser.parse();
        OrderManager.orderModelArrayList = parser.getOrderModels();
        OrderManager.table.setModel(new OrderTableModel(OrderManager.orderModelArrayList));
        // !!!SET GLOBAL STATUS FLAG!!!
        OrderManager.isModified = false;
        StatusComponent.updateStatus();
    }
}
