package ks3.pmf.view.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;

import ks3.pmf.model.Setting;
import ks3.pmf.model.Settings;
import ks3.pmf.view.ImagePanel;
import ks3.pmf.view.MainWindow;

public class SwingMainWindow implements MainWindow<Component> {
    
    private final JFrame frame;
    
    public SwingMainWindow() {
        frame = new JFrame(Settings.get(Setting.APPLICATION_NAME));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultDimensions();
    }

    private void setDefaultDimensions() {
        Integer width = Settings.getInteger(Setting.MAIN_WINDOW_WIDTH);
        Integer height = Settings.getInteger(Setting.MAIN_WINDOW_HEIGHT);
        frame.setMinimumSize(new Dimension(width, height));
    }
    
    @Override
    public void show() {
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void addImagePanel(ImagePanel<Component> imagePanel) {
        frame.add(imagePanel.getComponent(), BorderLayout.CENTER);
    }

}
