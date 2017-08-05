package ks3.pmf.model;

import java.io.File;

public interface ImageIconBuilder<T> {
    
    T build(File imageFile);
}
