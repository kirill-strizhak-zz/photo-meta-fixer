package ks3.pmf.model.loader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class FilesystemImageLoaderTest {
    
    private FilesystemImageLoader imageLoader;

    private void assertNumberOfImagesLoaded(String folderPath, int numberOfImages) {
        assertEquals(numberOfImages, imageLoader.loadAllImages(folderPath).size());
    }
    
    @Before
    public void setUp() {
        imageLoader = new FilesystemImageLoader();
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

    private void assertFileAccepted(String fileName) {
        assertTrue(imageLoader.isAcceptedFile(fakeFile(fileName, false)));
    }

    private File fakeFile(String name, boolean isFolder) {
        File file = Mockito.mock(File.class);
        Mockito.when(file.isDirectory()).thenReturn(isFolder);
        Mockito.when(file.getName()).thenReturn(name);
        return file;
    }
}
