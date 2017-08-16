package ks3.pmf.boundary;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import ks3.pmf.data.ImageFile;
import ks3.pmf.model.loaders.ImageLoader;

@SuppressWarnings("rawtypes")
public class Application {
    
    private final ImageLoader imageLoader;
    
    @SuppressWarnings("serial")
    public static class InterfaceInitializationError extends RuntimeException {
        public InterfaceInitializationError(Throwable cause) {
            super(cause);
        }
    }

    private final MainWindow mainWindow;

    private final ImagePanel imagePanel;

    private final MenuPanel menuPanel;

    @SuppressWarnings("unchecked")
    protected Application(Class<? extends MainWindow> mainWindowClass,
            Class<? extends ImagePanel> imagePanelClass, Class<? extends MenuPanel> menuPanelClass) {
        Settings.initialize("./settings.xml");
        try {
            this.mainWindow = mainWindowClass.newInstance();
            this.imagePanel = imagePanelClass.newInstance();
            this.menuPanel = menuPanelClass.getConstructor(Application.class).newInstance(this);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
            throw new InterfaceInitializationError(ex);
        }
        this.mainWindow.addImagePanel(imagePanel);
        this.mainWindow.addMenuPanel(menuPanel);
        
        int targetWidth = Settings.getInteger(Setting.IMAGE_ICON_WIDTH);
        int targetHeight = Settings.getInteger(Setting.IMAGE_ICON_HEIGHT);
        imageLoader = new ImageLoader(targetWidth, targetHeight);
        
        this.mainWindow.show();
    }

    @SuppressWarnings("unchecked")
    public void loadAllImages(String location) {
        try {
            List<ImageFile> imageFiles = imageLoader.loadAllImages(location);
            imagePanel.addAllImages(imageFiles);
            imagePanel.refreshImageDisplay();
            
        } catch (ImageLoader.NoLoaderFoundError ex) {
            //TODO: Error display
            System.out.println(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void addAllImages(List<ImageFile> imageFiles) {
        imagePanel.addAllImages(imageFiles);
    }

    @SuppressWarnings("unchecked")
    public List<ImageItem> getImageList() {
        return imagePanel.getImageList();
    }

    public void refreshImages() {
        imagePanel.refreshImageDisplay();
    }

}
