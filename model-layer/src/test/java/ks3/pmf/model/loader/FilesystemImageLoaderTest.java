package ks3.pmf.model.loader;

import static org.junit.Assert.*;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.junit.Test;

import ks3.pmf.model.ImageFile;
import ks3.pmf.model.awt.AwtImageFile;

public class FilesystemImageLoaderTest {

    private void assertNumberOfImagesLoaded(String folderPath, int numberOfImages) {
        assertEquals(numberOfImages, loadAllImages(folderPath).size());
    }

    @Test
    public void givenEmptyFolder_addNoImages() {
        assertNumberOfImagesLoaded("../src/test/resources/images", 0);
    }
    
    @Test
    public void givenFolderWithImages_addAll() {
        assertNumberOfImagesLoaded("../src/test/resources/images/two_basic_images", 2);
    }
    
    @Test
    public void givenFolderWithVariousFiles_addOnlyImages() {
        assertNumberOfImagesLoaded("../src/test/resources/images/various", 6);
    }

    @SuppressWarnings("rawtypes")
    public List<ImageFile> loadAllImages(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles(file -> !file.isDirectory() && file.getName().toLowerCase().matches(".*\\.(jpg|jpeg|bmp)$"));
        List<ImageFile> imageFiles = new ArrayList<>(files.length);
        
        Image image;
        for (File file: files) {
            try {
                image = ImageIO.read(file);
                imageFiles.add(new AwtImageFile(image, file.getName(), file.getName()));
            } catch (IOException ex) {
                System.out.println(String.format("Failed to load image from file '%s': %s", file.getName(), ex.getMessage()));
            }
        }
        return imageFiles;
    }
}
