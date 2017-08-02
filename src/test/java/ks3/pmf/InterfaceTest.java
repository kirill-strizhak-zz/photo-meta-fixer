package ks3.pmf;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ks3.pmf.model.Settings;
import ks3.pmf.model.awt.AwtImageFile;
import ks3.pmf.view.Application;

public class InterfaceTest {

    public static void main(String[] args) throws Exception {
        Settings.initialize("./settings.xml");
        Application.initialize();

        File imageFolder = new File("./src/test/resources/two_basic_images");
        for (int i = 0; i < 8; i++) {
            addTestImages(imageFolder.listFiles(), i);
        }
        Application.refreshImages();
    }

    private static void addTestImages(File[] files, int copyIdx) throws IOException {
        for (int itemIdx = 0; itemIdx < files.length; itemIdx++) {
            Image image = ImageIO.read(files[itemIdx]);
            AwtImageFile imageFile = createAwtImageFile(image, copyIdx, itemIdx);
            Application.addImage(imageFile);
        }
    }

    private static AwtImageFile createAwtImageFile(Image image, int copyIdx, int itemIdx) {
        String generatedName = String.format("gen_name_%d_%d", copyIdx, itemIdx);
        String fileName = String.format("file_name_%d_%d", copyIdx, itemIdx);
        return new AwtImageFile(image, generatedName, fileName);
    }

}
