package ks3.pmf.model.awt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.Image;
import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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
        ImageIconBuilder<Image> iconBuilder = Mockito.mock(ImageIconBuilder.class);
        Image icon = Mockito.mock(Image.class);
        Mockito.when(iconBuilder.build(Mockito.any(File.class))).thenReturn(icon);
        imageFileBuilder = new AwtImageFileBuilder(iconBuilder);
    }

    @Test
    public void givenFile_createAwtImageFile() {
        String fileName = "image.jpg";
        assertExpectedImageFile(imageFileBuilder.build(FileTestHelper.getMockFile(fileName)), fileName);
    }
}
