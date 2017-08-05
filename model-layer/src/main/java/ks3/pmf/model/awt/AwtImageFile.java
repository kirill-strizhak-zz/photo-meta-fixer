package ks3.pmf.model.awt;

import java.awt.Image;

import ks3.pmf.model.ImageFile;

public class AwtImageFile implements ImageFile<Image> {
    
    private Image icon;
    private String generatedName;
    private String fileName;
    
    protected AwtImageFile(Image icon, String generatedName, String fileName) {
        this.icon = icon;
        this.generatedName = generatedName;
        this.fileName = fileName;
    }

    @Override
    public Image getIcon() {
        return icon;
    }

    @Override
    public String getGeneratedName() {
        return generatedName;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

}
