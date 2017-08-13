package ks3.pmf.model.awt;

import java.awt.Image;

import ks3.pmf.data.ImageFile;

public class AwtImageFile implements ImageFile<Image> {
    
    private Image icon;
    private final String fileName;
    
    protected AwtImageFile(Image icon, String fileName) {
        this.icon = icon;
        this.fileName = fileName;
    }

    @Override
    public Image getIcon() {
        return icon;
    }

    @Override
    public String getGeneratedName() {
        return fileName;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

}
