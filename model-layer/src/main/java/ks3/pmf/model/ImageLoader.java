package ks3.pmf.model;

import java.util.List;

public interface ImageLoader {
    
    void setIconTargetDimensions(int targetWidth, int targetHeight);

    @SuppressWarnings("rawtypes")
    List<ImageFile> loadAllImages(String location);
}