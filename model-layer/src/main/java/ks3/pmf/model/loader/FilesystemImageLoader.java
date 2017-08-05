package ks3.pmf.model.loader;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import ks3.pmf.model.ImageFile;
import ks3.pmf.model.awt.AwtImageFile;

public class FilesystemImageLoader implements ImageLoader {

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
        try {
            Image image = ImageIO.read(file);
            imageFiles.add(new AwtImageFile(image, file.getName(), file.getName()));
        } catch (IOException ex) {
            System.out.println(String.format("Failed to load image from file '%s': %s", file.getName(), ex.getMessage()));
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
