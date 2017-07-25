package ks3.pmf.model.awt;

import java.awt.Image;

import ks3.pmf.model.ImageFile;

public class AwtImageFile implements ImageFile<Image> {

    @Override
    public Image getImage() {
        return null;
    }

    @Override
    public String getGeneratedName() {
        return "";
    }

    @Override
    public String getFileName() {
        return "";
    }

}
