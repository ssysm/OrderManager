package com.theeditorstudio.ordermanager.windows.components;

import com.theeditorstudio.ordermanager.OrderManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * Splash Welcome screen components
 */
public class SplashScreen {
    private final JWindow window;
    private long startTime;
    private int minimumMilliseconds;

    public SplashScreen() throws IOException {
        window = new JWindow();
        JPanel jPanel = new JPanel();
        InputStream inputStream = OrderManager.class.getClassLoader().getResourceAsStream("splash.png");
        assert inputStream != null : "Broken Jar File";
        // Set Splash Screen Image
        ImageIcon image = new ImageIcon(ImageIO.read(inputStream));
        jPanel.add(new JLabel("", image, SwingConstants.CENTER));
        jPanel.add(new JLabel("Version: " + OrderManager.class.getPackage().getImplementationVersion()
                              + "   Loading: " + OrderManager.class.getPackageName(),
                SwingConstants.LEADING));
        window.setContentPane(jPanel);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        window.setBounds((int) ((screenSize.getWidth() - image.getIconWidth()) / 2),
                (int) ((screenSize.getHeight() - image.getIconHeight()) / 2),
                image.getIconWidth(), image.getIconHeight() + 35);
    }

    public void show(int ms){
        this.minimumMilliseconds = ms;
        window.setVisible(true);
        startTime = System.currentTimeMillis();
    }

    public void hide() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        try {
            Thread.sleep(Math.max(minimumMilliseconds - elapsedTime, 0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.setVisible(false);
    }
}