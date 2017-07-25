package ks3.pmf.view;

import java.awt.Component;
import java.awt.Image;
import java.util.List;

import ks3.pmf.model.ImageFile;
import ks3.pmf.view.swing.SwingImagePanel;
import ks3.pmf.view.swing.SwingMainWindow;

public class Application {

    private static Application instance;
    
    private final MainWindow<Component, Image> mainFrame;
    private final ImagePanel<Component, Image> imagePanel;
    
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

    public static void addImage(ImageFile<Image> image) {
        instance.imagePanel.addImage(image);
    }

    public static List<ImageItem<Component>> getImageList() {
        return instance.imagePanel.getImageList();
    }

}
