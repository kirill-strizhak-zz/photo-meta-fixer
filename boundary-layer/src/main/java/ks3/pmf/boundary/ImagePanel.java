package ks3.pmf.boundary;

import java.util.List;

import ks3.pmf.data.ImageFile;

public interface ImagePanel<T, U> extends ComponentContainer<T> {

    void addAllImages(List<ImageFile<U>> imageFiles);
    List<ImageItem<T>> getImageList();
    void refreshImageDisplay();

}
