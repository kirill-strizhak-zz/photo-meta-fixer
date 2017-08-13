package ks3.pmf.model;

import java.io.File;

import ks3.pmf.data.ImageFile;

public interface ImageFileBuilder {

    @SuppressWarnings("rawtypes")
    ImageFile build(File file, int targetWidth, int targetHeight);
}
