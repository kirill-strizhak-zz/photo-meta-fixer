package ks3.pmf.view;

import static org.junit.Assert.*;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;

import ks3.pmf.model.Settings;

public class ApplicationTest {

    @Before
    public void setUp() {
        Settings.initialize("./settings.xml");
        Application.initialize();
    }
    
    @Test
    public void canAddImage() {
        ImageIcon image = new ImageIcon();
        Application.addImage(image);
        assertTrue(Application.getImageList().contains(image));
    }

}
