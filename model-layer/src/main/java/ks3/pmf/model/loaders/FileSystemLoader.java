package ks3.pmf.model.loaders;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ks3.pmf.data.ImageFile;
import ks3.pmf.model.ImageFileBuilder;
import ks3.pmf.model.ImageIconBuilder;

class FileSystemLoader implements Loader {
    
    private final ImageFileBuilder imageFileBuilder;
    private int targetWidth;
    private int targetHeight;

    public FileSystemLoader(ImageFileBuilder imageFileBuilder, int targetWidth, int targetHeight) {
        this.imageFileBuilder = imageFileBuilder;
        this.targetWidth = targetWidth;
        this.targetHeight = targetHeight;
    }

    @Override
    public void setIconTargetDimensions(int targetWidth, int targetHeight) {
        this.targetWidth = targetWidth;
        this.targetHeight = targetHeight;
    }

    @Override
    @SuppressWarnings("rawtypes")
    public List<ImageFile> loadAllImages(String location) {
        File[] files = new File(location).listFiles(this::isAcceptedFile);
        return loadAllFiles(files);
    }

    @Override
    public boolean canLoadFrom(String location) {
        return new File(location).canRead();
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
        try {
            imageFiles.add(imageFileBuilder.build(file, targetWidth, targetHeight));
        } catch (ImageIconBuilder.FailedToLoadFile ex) {
            System.out.println(String.format("Failed to load file '%s': %s", file.getName(), ex.getMessage()));
        }
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
