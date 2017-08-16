package ks3.pmf.model.loaders;

import java.util.List;

import ks3.pmf.data.ImageFile;

interface Loader {
    
    void setIconTargetDimensions(int targetWidth, int targetHeight);

    boolean canLoadFrom(String location);

    @SuppressWarnings("rawtypes")
    List<ImageFile> loadAllImages(String location);
}