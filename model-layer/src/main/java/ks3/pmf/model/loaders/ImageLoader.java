package ks3.pmf.model.loaders;

import java.util.ArrayList;
import java.util.List;

import ks3.pmf.data.ImageFile;
import ks3.pmf.model.ImageFileBuilder;
import ks3.pmf.model.awt.AwtImageFileBuilder;
import ks3.pmf.model.awt.AwtImageIconBuilder;

public class ImageLoader {
    
    @SuppressWarnings("serial")
    public static class NoLoaderFoundError extends RuntimeException {
        public NoLoaderFoundError(String location) {
            super("No loader capable of reading files from '" + location + "'");
        }
    }
    
    private List<Loader> loaders = new ArrayList<>();
    
    public ImageLoader(int targetWidth, int targetHeight) {
        AwtImageIconBuilder iconBuilder = new AwtImageIconBuilder();
        AwtImageFileBuilder imageFileBuilder = new AwtImageFileBuilder(iconBuilder);
        initialize(imageFileBuilder, targetWidth, targetHeight);
    }
    
    protected ImageLoader(ImageFileBuilder imageFileBuilder, int targetWidth, int targetHeight) {
        initialize(imageFileBuilder, targetWidth, targetHeight);
    }
    
    private void initialize(ImageFileBuilder imageFileBuilder, int targetWidth, int targetHeight) {
        loaders.add(new FileSystemLoader(imageFileBuilder, targetWidth, targetHeight));
    }

    public void setIconTargetDimensions(int targetWidth, int targetHeight) {
        loaders.stream().forEach(loader -> loader.setIconTargetDimensions(targetWidth, targetHeight));
    }

    @SuppressWarnings("rawtypes")
    public List<ImageFile> loadAllImages(String location) {
        return findLoaderFor(location).loadAllImages(location);
    }

    private Loader findLoaderFor(String location) {
        for (Loader loader: loaders) {
            if (loader.canLoadFrom(location)) {
                return loader;
            }
        }
        
        throw new NoLoaderFoundError(location);
    }

    protected List<Loader> getLoaders() {
        return loaders;
    }

}
