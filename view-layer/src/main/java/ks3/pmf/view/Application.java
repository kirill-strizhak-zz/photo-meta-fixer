package ks3.pmf.view;

import java.util.List;

import javax.swing.ImageIcon;

import ks3.pmf.view.swing.SwingImagePanel;
import ks3.pmf.view.swing.SwingMainWindow;

public class Application {

    private static Application instance;
    
    private final MainWindow mainFrame;
    private final ImagePanel imagePanel;
    
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
        
    }

    public static List<ImageIcon> getImages() {
        return null;
    }

}
