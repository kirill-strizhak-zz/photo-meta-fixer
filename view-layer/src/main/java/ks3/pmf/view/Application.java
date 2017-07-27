package ks3.pmf.view;

import java.util.List;

import ks3.pmf.model.ImageFile;
import ks3.pmf.view.swing.SwingImagePanel;
import ks3.pmf.view.swing.SwingMainWindow;

public class Application {

    private static Application instance;

    @SuppressWarnings("rawtypes")
    private final MainWindow mainFrame;
    
    @SuppressWarnings("rawtypes")
    private final ImagePanel imagePanel;
    
    @SuppressWarnings("unchecked")
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

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void addImage(ImageFile image) {
        instance.imagePanel.addImage(image);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List<ImageItem> getImageList() {
        return instance.imagePanel.getImageList();
    }

}
