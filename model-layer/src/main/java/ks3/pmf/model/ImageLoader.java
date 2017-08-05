package ks3.pmf.model;

import java.util.List;

public interface ImageLoader {

    @SuppressWarnings("rawtypes")
    List<ImageFile> loadAllImages(String location);

}