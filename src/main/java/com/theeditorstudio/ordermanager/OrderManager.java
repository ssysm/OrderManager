package com.theeditorstudio.ordermanager;

import com.theeditorstudio.ordermanager.actions.menu.OpenFileAction;
import com.theeditorstudio.ordermanager.adapters.MainWindowAdapter;
import com.theeditorstudio.ordermanager.adapters.TableMouseAdapter;
import com.theeditorstudio.ordermanager.menus.MenuBarFactory;
import com.theeditorstudio.ordermanager.menus.QuickActionBar;
import com.theeditorstudio.ordermanager.menus.TableCtxMenu;
import com.theeditorstudio.ordermanager.models.OrderModel;
import com.theeditorstudio.ordermanager.models.OrderTableModel;
import com.theeditorstudio.ordermanager.windows.components.SplashScreen;
import com.theeditorstudio.ordermanager.windows.components.StatusComponent;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class OrderManager extends JFrame {

    /** Set Global Variable */
    public static JFrame frame = new JFrame();
    public static JTable table = new JTable(new OrderTableModel());
    public static ArrayList<OrderModel> orderModelArrayList = new ArrayList<>();
    public static boolean isModified = false;
    public static File currentFile = new File("order.csv");
    public static JLabel status =  new JLabel("Order Manager");

    // Get All Components Factory
    JPanel toolbar = new QuickActionBar().getToolBar();
    JMenuBar menuBar = new MenuBarFactory().getMenuBar();
    JScrollPane scrollPane = new JScrollPane(table);
    JPopupMenu popupMenu = new TableCtxMenu().getPopupMenu();
    Dimension windowSize = new Dimension(700, 500);

    public static void main(String[] args) throws IOException {
        OrderManager orderManager = new OrderManager();
        SplashScreen splashScreen = new SplashScreen();
        splashScreen.show(3000);
        splashScreen.hide();
        orderManager.run();
        StatusComponent.updateStatus();
    }

    private void run(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // Set Frame Options
        frame.setBounds((int) ((screenSize.getWidth() - windowSize.getWidth())/ 2),
                (int) ((screenSize.getHeight() - windowSize.getHeight())/ 2),
                (int) windowSize.getWidth(), (int) windowSize.getHeight()); // set center screen
        frame.setMinimumSize(windowSize);
        frame.setSize((int)windowSize.getWidth(),(int)windowSize.getHeight());
        frame.setTitle("Order Manager");
        frame.setLayout(new BorderLayout());
        frame.setJMenuBar(menuBar);
        frame.add(toolbar, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(status, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new MainWindowAdapter());
        frame.setVisible(true);
        // Set Table Options
        table.setAutoCreateRowSorter(true);
        table.setComponentPopupMenu(popupMenu);
        table.addMouseListener(new TableMouseAdapter());
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

}
