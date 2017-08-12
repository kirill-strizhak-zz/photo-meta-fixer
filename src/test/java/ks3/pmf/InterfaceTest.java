package ks3.pmf;

import java.util.List;

import ks3.pmf.model.ImageFile;
import ks3.pmf.model.Setting;
import ks3.pmf.model.Settings;
import ks3.pmf.model.awt.AwtImageFileBuilder;
import ks3.pmf.model.awt.AwtImageIconBuilder;
import ks3.pmf.model.loaders.FilesystemImageLoader;
import ks3.pmf.view.Application;

public class InterfaceTest {

    public static void main(String[] args) throws Exception {
        Settings.initialize("./settings.xml");
        Application app = Application.getInstance();

        int targetWidth = Settings.getInteger(Setting.IMAGE_ICON_WIDTH);
        int targetHeight = Settings.getInteger(Setting.IMAGE_ICON_HEIGHT);
        
        AwtImageIconBuilder iconBuilder = new AwtImageIconBuilder();
        AwtImageFileBuilder fileBuilder = new AwtImageFileBuilder(iconBuilder);
        FilesystemImageLoader imageLoader = new FilesystemImageLoader(fileBuilder, targetWidth, targetHeight);
        
        @SuppressWarnings("rawtypes")
        List<ImageFile> imageFiles = imageLoader.loadAllImages("./src/test/resources/images/various");
        imageFiles.stream().forEachOrdered(app::addImage);
        
        app.refreshImages();
    }
}
