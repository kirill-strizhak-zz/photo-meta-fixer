package ks3.pmf.view.swing;

import java.awt.image.BufferedImage;

import org.mockito.Mockito;

import ks3.pmf.data.ImageFile;

@SuppressWarnings("rawtypes")
public class SwingTestsHelper {

    public static ImageFile getMockImageFile() {
        return getMockImageFile("fileName", "generatedName", 20, 10);
    }

    public static ImageFile getMockImageFile(String fileName, String generatedName, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        ImageFile imageFile = Mockito.mock(ImageFile.class);
        Mockito.when(imageFile.getIcon()).thenReturn(image);
        Mockito.when(imageFile.getFileName()).thenReturn(fileName);
        Mockito.when(imageFile.getGeneratedName()).thenReturn(generatedName);
        return imageFile;
    }

}
