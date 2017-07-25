package ks3.pmf.view.swing;

import java.awt.image.BufferedImage;

import org.mockito.Mockito;

import ks3.pmf.model.awt.AwtImageFile;

public class SwingTestsHelper {

    public static AwtImageFile getMockImageFile() {
        return getMockImageFile("fileName", "generatedName", 20, 10);
    }

    public static AwtImageFile getMockImageFile(String fileName, String generatedName, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        AwtImageFile imageFile = Mockito.mock(AwtImageFile.class);
        Mockito.when(imageFile.getImage()).thenReturn(image);
        Mockito.when(imageFile.getFileName()).thenReturn(fileName);
        Mockito.when(imageFile.getGeneratedName()).thenReturn(generatedName);
        return imageFile;
    }

}
