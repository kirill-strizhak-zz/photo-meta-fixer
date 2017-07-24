package ks3.pmf.view;

import java.util.List;

public interface MainWindow<T,U> {

    void show();
    void addImagePanel(ImagePanel<T> imagePanel);
    void addListener(List<U> listenerList);

}
