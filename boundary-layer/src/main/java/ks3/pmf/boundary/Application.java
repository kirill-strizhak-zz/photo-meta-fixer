package ks3.pmf.boundary;

import java.util.List;

import ks3.pmf.data.ImageFile;

public class Application {
    
    @SuppressWarnings("serial")
    private static class InterfaceInitializationError extends RuntimeException {
        public InterfaceInitializationError(Throwable cause) {
            super(cause);
        }
    }

    @SuppressWarnings("rawtypes")
    private final MainWindow mainWindow;

    @SuppressWarnings("rawtypes")
    private final ImagePanel imagePanel;

    @SuppressWarnings("rawtypes")
    private final MenuPanel menuPanel;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected Application(Class<? extends MainWindow> mainWindowClass,
            Class<? extends ImagePanel> imagePanelClass, Class<? extends MenuPanel> menuPanelClass) {
        Settings.initialize("./settings.xml");
        try {
            this.mainWindow = mainWindowClass.newInstance();
            this.imagePanel = imagePanelClass.newInstance();
            this.menuPanel = menuPanelClass.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new InterfaceInitializationError(ex);
        }
        this.mainWindow.addImagePanel(imagePanel);
        this.mainWindow.addMenuPanel(menuPanel);
        this.mainWindow.show();
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
