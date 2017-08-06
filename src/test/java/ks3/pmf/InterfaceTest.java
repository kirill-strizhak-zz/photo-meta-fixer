package ks3.pmf;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ks3.pmf.model.ImageFileBuilder;
import ks3.pmf.model.ImageIconBuilder;
import ks3.pmf.model.Settings;
import ks3.pmf.model.awt.AwtImageFileBuilder;
import ks3.pmf.view.Application;

public class InterfaceTest {

    public static void main(String[] args) throws Exception {
        Settings.initialize("./settings.xml");
        Application.initialize();

        File imageFolder = new File("./src/test/resources/images/two_basic_images");
        for (int i = 0; i < 8; i++) {
            addTestImages(imageFolder.listFiles(), i);
        }
        Application.refreshImages();
    }

    private static void addTestImages(File[] files, int copyIdx) {
        ImageFileBuilder imageFileBuilder = new AwtImageFileBuilder(file -> {
            try {
                return ImageIO.read(file);
            } catch (IOException ex) {
                throw new ImageIconBuilder.FailedToLoadFile();
            }
        });
        for (int itemIdx = 0; itemIdx < files.length; itemIdx++) {
            Application.addImage(imageFileBuilder.build(files[itemIdx]));
        }
    }
}
