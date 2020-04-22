package com.theeditorstudio.ordermanager;

import com.theeditorstudio.ordermanager.actions.menu.OpenFileAction;
import com.theeditorstudio.ordermanager.adapters.MainWindowAdapter;
import com.theeditorstudio.ordermanager.adapters.TableMouseAdapter;
import com.theeditorstudio.ordermanager.menus.MenuBarFactory;
import com.theeditorstudio.ordermanager.menus.QuickActionBar;
import com.theeditorstudio.ordermanager.menus.TableCtxMenu;
import com.theeditorstudio.ordermanager.models.OrderModel;
import com.theeditorstudio.ordermanager.models.OrderTableModel;
import com.theeditorstudio.ordermanager.windows.components.StatusComponent;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class OrderManager extends JFrame {

    /** Set Global Variable */
    public static JFrame frame = new JFrame();
    public static JTable table = new JTable(new OrderTableModel());
    public static ArrayList<OrderModel> orderModelArrayList = new ArrayList<OrderModel>();
    public static boolean isModified = false;
    public static File currentFile = new File("order.csv");
    public static JLabel status =  new JLabel("Order Manager");

    // Get All Components Factory
    JPanel toolbar = new QuickActionBar().getToolBar();
    JMenuBar menuBar = new MenuBarFactory().getMenuBar();
    JScrollPane scrollPane = new JScrollPane(table);
    JPopupMenu popupMenu = new TableCtxMenu().getPopupMenu();

    public static void main(String[] args){
        OrderManager orderManager = new OrderManager();
        orderManager.run();
        // Initial File Chooser Open
        OpenFileAction openFileAction = new OpenFileAction();
        openFileAction.actionPerformed(null);
        StatusComponent.updateStatus();
    }

    private void run(){
        // Set Frame Options
        frame.setMinimumSize(new Dimension(640, 480));
        frame.setSize(700,500);
        frame.setTitle("Order Manager");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setJMenuBar(menuBar);
        frame.add(toolbar, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(status, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new MainWindowAdapter());
        // Set Table Options
        table.setAutoCreateRowSorter(true);
        table.setComponentPopupMenu(popupMenu);
        table.addMouseListener(new TableMouseAdapter());
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

}
