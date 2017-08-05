package ks3.pmf.model.loaders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ks3.pmf.model.FileTestHelper;
import ks3.pmf.model.ImageFileBuilder;

public class FilesystemImageLoaderTest {

    private FilesystemImageLoader imageLoader;

    private void assertNumberOfImagesLoaded(String folderPath, int numberOfImages) {
        assertEquals(numberOfImages, imageLoader.loadAllImages(folderPath).size());
    }

    private void assertFileAccepted(String fileName) {
        assertTrue(imageLoader.isAcceptedFile(FileTestHelper.getMockFile(fileName)));
    }

    private void assertFileNotAccepted(String fileName) {
        assertFalse(imageLoader.isAcceptedFile(FileTestHelper.getMockFile(fileName)));
    }
    
    @Before
    public void setUp() {
        ImageFileBuilder iconCreator = Mockito.mock(ImageFileBuilder.class);
        Mockito.when(iconCreator.build(Mockito.any(File.class))).thenReturn(null);
        imageLoader = new FilesystemImageLoader(iconCreator);
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
    
    @Test
    public void givenMatchingExtension_accept() {
        assertFileAccepted("image.jpg");
        assertFileAccepted("image.jpeg");
    }
    
    @Test
    public void givenNonMatchingExtension_reject() {
        assertFileNotAccepted("name");
        assertFileNotAccepted("image.tiff");
    }
    
    @Test
    public void givenFolder_reject() {
        assertFalse(imageLoader.isAcceptedFile(FileTestHelper.getMockFile("folder", true)));
    }
}
