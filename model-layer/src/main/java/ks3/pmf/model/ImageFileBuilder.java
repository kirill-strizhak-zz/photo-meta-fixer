package ks3.pmf.model;

import java.io.File;

public interface ImageFileBuilder {

    @SuppressWarnings("rawtypes")
    ImageFile build(File file);
}
