package ks3.pmf.model;

import java.io.File;

public interface ImageIconBuilder<T> {
    
    static class FailedToLoadFile extends RuntimeException {
        private static final long serialVersionUID = 1L;
    }
    
    T build(File file, int targetWidth, int targetHeight);
}
