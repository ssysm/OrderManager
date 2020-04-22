
package com.theeditorstudio.ordermanager.adapters;

import com.theeditorstudio.ordermanager.actions.table.OrderDetailAction;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
* Table Mouse Event Adapter
* This Inherit the Swing MouseAdapter from the JTable
* class and impl a double-click event
*/
public class TableMouseAdapter extends MouseAdapter {
    /**
     * Trigger Detail view on a double click
     * @param e MouseEvent
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){
            ActionListener actionListener = new OrderDetailAction();
            actionListener.actionPerformed(null);
        }
    }
}
