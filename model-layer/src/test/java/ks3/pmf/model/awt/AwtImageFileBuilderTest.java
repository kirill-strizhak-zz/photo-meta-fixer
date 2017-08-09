package ks3.pmf.model.awt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import java.awt.Image;
import java.io.File;

import org.junit.Before;
import org.junit.Test;

import ks3.pmf.model.FileTestHelper;
import ks3.pmf.model.ImageFile;
import ks3.pmf.model.ImageIconBuilder;

public class AwtImageFileBuilderTest {
    
    private AwtImageFileBuilder imageFileBuilder;
    
    private void assertExpectedImageFile(@SuppressWarnings("rawtypes") ImageFile imageFile, String name) {
        assertEquals(name, imageFile.getFileName());
        assertEquals(name, imageFile.getGeneratedName());
        assertNotNull(imageFile.getIcon());
    }
    
    @Before
    public void setUp() {
        @SuppressWarnings("unchecked")
        ImageIconBuilder<Image> iconBuilder = mock(ImageIconBuilder.class);
        Image icon = mock(Image.class);
        when(iconBuilder.build(any(File.class), anyInt(), anyInt())).thenReturn(icon);
        imageFileBuilder = new AwtImageFileBuilder(iconBuilder);
    }

    @Test
    public void givenFile_createAwtImageFile() {
        String fileName = "image.jpg";
        assertExpectedImageFile(imageFileBuilder.build(FileTestHelper.getMockFile(fileName), 0, 0), fileName);
    }
}
