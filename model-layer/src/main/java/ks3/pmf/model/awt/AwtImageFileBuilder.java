package ks3.pmf.model.awt;

import java.io.File;

import ks3.pmf.model.ImageFile;
import ks3.pmf.model.ImageFileBuilder;

public class AwtImageFileBuilder implements ImageFileBuilder {

    @Override
    @SuppressWarnings("rawtypes")
    public ImageFile build(File file) {
        return new AwtImageFile(null, "", "");
    }

}
