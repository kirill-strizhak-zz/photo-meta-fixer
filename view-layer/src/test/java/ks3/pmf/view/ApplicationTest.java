package ks3.pmf.view;

import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import org.junit.Ignore;
import org.junit.Test;

import ks3.pmf.model.Settings;

public class ApplicationTest {

    @Test
    public void canCreate() {
        Settings.initialize("./settings.xml");
        Application.initialize();
    }
    
    @Ignore
    @Test
    public void canAddImage() {
        ImageIcon image = new ImageIcon();
        Application.addImage(image);
        assertTrue(Application.getImages().contains(image));
    }

}
