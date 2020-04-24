package com.theeditorstudio.ordermanager.utils;

import com.theeditorstudio.ordermanager.OrderManager;

import javax.swing.*;
import java.io.File;

/**
 * Save File Chooser(Inh. from JFileChooser)
 *
 * This class create a custom prompt when the user is trying
 * to overwrite an existing file.
 */
public class SaveFileChooser extends JFileChooser {

    @Override
    public void approveSelection() {
        File f = getSelectedFile();
        if (f.exists() && getDialogType() == SAVE_DIALOG) {
            int result = JOptionPane.showConfirmDialog(OrderManager.frame, "The file exists, overwrite?", "Existing file", JOptionPane.YES_NO_CANCEL_OPTION);
            switch (result) {
                case JOptionPane.YES_OPTION:
                    super.approveSelection();
                    return;
                case JOptionPane.NO_OPTION:
                    return;
                case JOptionPane.CLOSED_OPTION:
                    return;
                case JOptionPane.CANCEL_OPTION:
                    cancelSelection();
                    return;
            }
        }
        super.approveSelection();
    }
}
