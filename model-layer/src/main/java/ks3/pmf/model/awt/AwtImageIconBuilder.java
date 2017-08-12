package ks3.pmf.model.awt;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;

import ks3.pmf.model.ImageIconBuilder;

public class AwtImageIconBuilder implements ImageIconBuilder<Image> {

    public Image build(File file, int targetWidth, int targetHeight) {
        try {
            BufferedImage image = ImageIO.read(file);
            return Scalr.resize(image, Method.SPEED, targetWidth, targetHeight);
        } catch (IOException ex) {
            throw new ImageIconBuilder.FailedToLoadFile(ex);
        }
    }

}
