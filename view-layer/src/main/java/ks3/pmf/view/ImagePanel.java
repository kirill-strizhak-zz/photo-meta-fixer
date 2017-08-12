package ks3.pmf.view;

import java.util.List;

import ks3.pmf.model.ImageFile;

public interface ImagePanel<T, U> extends ComponentContainer<T> {

    void addImage(ImageFile<U> imageFile);
    List<ImageItem<T>> getImageList();
    void refreshImageDisplay();

}
