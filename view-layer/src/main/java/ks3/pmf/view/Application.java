package ks3.pmf.view;

import java.util.List;

import ks3.pmf.model.ImageFile;
import ks3.pmf.view.swing.SwingImagePanel;
import ks3.pmf.view.swing.SwingMainWindow;
import ks3.pmf.view.swing.SwingMenuPanel;

public class Application {

    private static Application instance;

    @SuppressWarnings("rawtypes")
    private final MainWindow mainFrame;
    
    @SuppressWarnings("rawtypes")
    private final ImagePanel imagePanel;
    
    @SuppressWarnings("rawtypes")
    private final MenuPanel menuPanel;
    
    @SuppressWarnings("unchecked")
    private Application() {
        mainFrame = new SwingMainWindow();
        imagePanel = new SwingImagePanel();
        menuPanel = new SwingMenuPanel();
        mainFrame.addImagePanel(imagePanel);
        mainFrame.addMenuPanel(menuPanel);
        mainFrame.show();
    }

    public static Application getInstance() {
        if (instance == null) {
            instance = new Application();
        }
        return instance;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void addImage(ImageFile image) {
        imagePanel.addImage(image);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<ImageItem> getImageList() {
        return imagePanel.getImageList();
    }
    
    public void refreshImages() {
        imagePanel.refreshImageDisplay();
    }

}
