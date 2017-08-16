package ks3.pmf.view.swing;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import ks3.pmf.data.ImageFile;

public class SwingApplicationTest {
    
    private SwingApplication app;

    @Before
    public void setUp() {
        app = SwingApplication.getInstance();
    }
    
    @Test
    public void canAddImage() {
        @SuppressWarnings("rawtypes")
        ImageFile imageFile = SwingTestsHelper.getMockImageFile();
        app.addAllImages(Collections.singletonList(imageFile));
        app.refreshImages();
        assertEquals(1, app.getImageList().size());
    }

}
