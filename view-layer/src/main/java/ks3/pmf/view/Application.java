package ks3.pmf.view;

import java.awt.Component;
import java.util.List;

import javax.swing.ImageIcon;

import ks3.pmf.view.swing.SwingImagePanel;
import ks3.pmf.view.swing.SwingMainWindow;

public class Application {

    private static Application instance;
    
    private final MainWindow<Component> mainFrame;
    private final ImagePanel<Component> imagePanel;
    
    private Application() {
        mainFrame = new SwingMainWindow();
        imagePanel = new SwingImagePanel();
        mainFrame.addImagePanel(imagePanel);
        mainFrame.show();
    }

    public static void initialize() {
        if (instance == null) {
            instance = new Application();
        }
    }

    public static void addImage(ImageIcon image) {
        instance.imagePanel.addImage(image);
    }

    public static List<ImageIcon> getImageList() {
        return instance.imagePanel.getImageList();
    }

}
