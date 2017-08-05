package ks3.pmf.model.loader;

import java.util.List;

import ks3.pmf.model.ImageFile;

public interface ImageLoader {

    @SuppressWarnings("rawtypes")
    List<ImageFile> loadAllImages(String location);

}