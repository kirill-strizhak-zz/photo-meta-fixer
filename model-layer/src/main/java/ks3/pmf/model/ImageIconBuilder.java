package ks3.pmf.model;

import java.io.File;

public interface ImageIconBuilder<T> {

    @SuppressWarnings("serial")
    static class FailedToLoadFile extends RuntimeException {
        public FailedToLoadFile(Throwable cause) {
            super(cause);
        }
    }
    
    T build(File file, int targetWidth, int targetHeight);
}
