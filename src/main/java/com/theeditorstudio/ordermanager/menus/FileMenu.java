package com.theeditorstudio.ordermanager.menus;

import com.theeditorstudio.ordermanager.actions.menu.BlankDBAction;
import com.theeditorstudio.ordermanager.actions.menu.OpenFileAction;
import com.theeditorstudio.ordermanager.actions.menu.QuitAction;
import com.theeditorstudio.ordermanager.actions.menu.SaveFileAction;
import com.theeditorstudio.ordermanager.interfaces.IMenu;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * File Menu Factory
 */
public class FileMenu extends JMenu implements IMenu {
    JMenu menu = new JMenu("File");

    JMenuItem open_file, save_file, quit, gen_file,new_file;

    /**
     * Construct File Menu
     */
    public FileMenu(){
        // Construct menu item
        new_file = new JMenuItem("New Database");
        new_file.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        new_file.addActionListener(new BlankDBAction());
        new_file.setMnemonic(KeyEvent.VK_N);

        open_file = new JMenuItem("Open Database");
        open_file.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        open_file.addActionListener(new OpenFileAction());
        open_file.setMnemonic(KeyEvent.VK_O);

        save_file = new JMenuItem("Save Database");
        save_file.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        save_file.addActionListener(new SaveFileAction());
        save_file.setMnemonic(KeyEvent.VK_S);

        gen_file = new JMenuItem("Generate Blank Database");
        gen_file.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
        gen_file.addActionListener(new SaveFileAction());
        gen_file.setMnemonic(KeyEvent.VK_G);

        quit = new JMenuItem("Quit");
        quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
        quit.addActionListener(new QuitAction());
        quit.setMnemonic(KeyEvent.VK_Q);
        // Map Menu Layout
        menu.add(new_file);
        menu.add(open_file);
        menu.add(save_file);
        menu.add(gen_file);
        menu.addSeparator();
        menu.add(quit);
        menu.setMnemonic(KeyEvent.VK_F);
    }

    /**
     * Get the constructed menu
     * @return JMenu
     */
    @Override
    public JMenu getMenu() {
        return menu;
    }
}
