package ks3.pmf.view;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ks3.pmf.model.Settings;
import ks3.pmf.model.awt.AwtImageFile;
import ks3.pmf.view.swing.SwingTestsHelper;

public class ApplicationTest {

    @Before
    public void setUp() {
        Settings.initialize("./settings.xml");
        Application.initialize();
    }
    
    @Test
    public void canAddImage() {
        AwtImageFile imageFile = SwingTestsHelper.getMockImageFile();
        Application.addImage(imageFile);
        Application.refreshImages();
        assertEquals(1, Application.getImageList().size());
    }

}
