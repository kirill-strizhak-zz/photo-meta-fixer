package ks3.pmf.model.awt;

import static org.junit.Assert.assertEquals;

import java.awt.Image;
import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class AwtImageIconBuilderTest {
    
    private static final int SIZE_CONSTRAINT = 6;
    
    private AwtImageIconBuilder iconBuilder;
    
    private void assertIconFitConstraints(String imagePath, int constraintW, int constraintH, int resultW, int resultH) {
        File file = new File(imagePath);
        Image icon = iconBuilder.build(file, constraintW, constraintH);
        assertEquals(resultW, icon.getWidth(null));
        assertEquals(resultH, icon.getHeight(null));
    }
    
    @Before
    public void setUp() {
        iconBuilder = new AwtImageIconBuilder();
    }

    @Test
    public void givenHorizontalImage_iconFitsConstraints() {
        String imagePath = "../src/test/resources/images/two_basic_images/horizontal.bmp";
        assertIconFitConstraints(imagePath, SIZE_CONSTRAINT, SIZE_CONSTRAINT, SIZE_CONSTRAINT, 4);
    }

    @Test
    public void givenVerticalImage_iconFitsConstraints() {
        String imagePath = "../src/test/resources/images/two_basic_images/vertical.bmp";
        assertIconFitConstraints(imagePath, SIZE_CONSTRAINT, SIZE_CONSTRAINT, 4, SIZE_CONSTRAINT);
    }
}
