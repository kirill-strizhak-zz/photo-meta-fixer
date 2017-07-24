package ks3.pmf.view;

import java.util.List;

import javax.swing.ImageIcon;

public interface ImagePanel<T> {
    
    T getComponent();
    void addImage(ImageIcon imageIcon);
    List<ImageIcon> getImageList();

}
