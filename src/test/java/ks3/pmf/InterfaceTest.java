package ks3.pmf;

import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

import ks3.pmf.model.Settings;
import ks3.pmf.model.awt.AwtImageFile;
import ks3.pmf.view.Application;

public class InterfaceTest {

    public static void main(String[] args) throws Exception {
        Settings.initialize("./settings.xml");
        Application.initialize();

        File imageFolder = new File("./view-layer/src/test/resources/images");
        File[] files = imageFolder.listFiles();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < files.length; j++) {
                Image image = ImageIO.read(files[j]);
                AwtImageFile imageFile = new AwtImageFile(image, "gen_name_" + i + "_" + j, "file_name_" + i + "_" + j);
                Application.addImage(imageFile);
            }
        }
        Application.refreshImages();
    }

}
