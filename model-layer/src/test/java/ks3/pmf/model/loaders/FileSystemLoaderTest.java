package ks3.pmf.model.loaders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import ks3.pmf.model.FileTestHelper;
import ks3.pmf.model.ImageFileBuilder;

public class FileSystemLoaderTest {
    
    private static final int WIDTH = 1;
    private static final int HEIGHT = 2;
    
    private static final String TWO_IMG_PATH = "../src/test/resources/images/two_basic_images";

    private FileSystemLoader loader;
    private ImageFileBuilder fileBuilder;

    private void assertNumberOfImagesLoaded(String folderPath, int numberOfImages) {
        assertEquals(numberOfImages, loader.loadAllImages(folderPath).size());
    }

    private void assertFileAccepted(String fileName) {
        assertTrue(loader.isAcceptedFile(FileTestHelper.getMockFile(fileName)));
    }

    private void assertFileNotAccepted(String fileName) {
        assertFalse(loader.isAcceptedFile(FileTestHelper.getMockFile(fileName)));
    }

    @Before
    public void setUp() {
        fileBuilder = mock(ImageFileBuilder.class);
        when(fileBuilder.build(any(File.class), anyInt(), anyInt())).thenReturn(null);
        loader = new FileSystemLoader(fileBuilder, WIDTH, HEIGHT);
    }

    @Test
    public void givenEmptyFolder_addNoImages() {
        assertNumberOfImagesLoaded("../src/test/resources/images", 0);
    }

    @Test
    public void givenFolderWithImages_addAll() {
        assertNumberOfImagesLoaded(TWO_IMG_PATH, 2);
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
        assertFalse(loader.isAcceptedFile(FileTestHelper.getMockFile("folder", true)));
    }
    
    @Test
    public void givenAccessibleFilesystemPath_accept() {
        assertTrue(loader.canLoadFrom("."));
    }
    
    @Test
    public void givenOtherPath_reject() {
        assertFalse(loader.canLoadFrom("http://google.com"));
    }
    
    @Test
    public void afterDimensionUpdate_fileBuilderCalledWithCorrectDimensions() {
        loader.loadAllImages(TWO_IMG_PATH);
        verify(fileBuilder, times(2)).build(any(File.class), eq(WIDTH), eq(HEIGHT));
        loader.setIconTargetDimensions(10, 11);
        loader.loadAllImages(TWO_IMG_PATH);
        verify(fileBuilder, times(2)).build(any(File.class), eq(10), eq(11));
    }
}
