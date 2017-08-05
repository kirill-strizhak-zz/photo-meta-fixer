package ks3.pmf.model.loaders;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ks3.pmf.model.ImageFile;
import ks3.pmf.model.ImageFileBuilder;
import ks3.pmf.model.ImageLoader;

public class FilesystemImageLoader implements ImageLoader {
    
    private final ImageFileBuilder imageFileBuilder;

    public FilesystemImageLoader(ImageFileBuilder imageFileBuilder) {
        this.imageFileBuilder = imageFileBuilder;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public List<ImageFile> loadAllImages(String location) {
        File[] files = new File(location).listFiles(this::isAcceptedFile);
        return loadAllFiles(files);
    }

    @SuppressWarnings("rawtypes")
    private List<ImageFile> loadAllFiles(File[] files) {
        List<ImageFile> imageFiles = new ArrayList<>(files.length);
        for (File file: files) {
            tryToLoadFile(imageFiles, file);
        }
        return imageFiles;
    }

    @SuppressWarnings("rawtypes")
    private void tryToLoadFile(List<ImageFile> imageFiles, File file) {
        imageFiles.add(imageFileBuilder.build(file));
    }

    protected boolean isAcceptedFile(File file) {
        return !file.isDirectory() && fileNameMatches(file);
    }

    private boolean fileNameMatches(File file) {
        return file.getName().toLowerCase().matches(getFileFilterRegex());
    }

    private String getFileFilterRegex() {
        return ".*\\.(jpg|jpeg|bmp)$";
    }
}
