package ks3.pmf.model.awt;

import java.awt.Image;

import ks3.pmf.model.ImageFile;

public class AwtImageFile implements ImageFile<Image> {
    
    private Image image;
    private String generatedName;
    private String fileName;
    
    /**
     * @deprecated Temporary constructor for testing. Will be removed.
     */
    @Deprecated
    public AwtImageFile(Image image, String generatedName, String fileName) {
        this.image = image;
        this.generatedName = generatedName;
        this.fileName = fileName;
    }

    @Override
    public Image getImage() {
        return image;
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
