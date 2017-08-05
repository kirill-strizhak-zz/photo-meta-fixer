package ks3.pmf.model.awt;

import org.junit.Assert;
import org.junit.Test;

import ks3.pmf.model.FileTestHelper;

public class AwtImageFileBuilderTest {

    @Test
    public void givenFile_createAwtImageFile() {
        AwtImageFileBuilder imageFileBuilder = new AwtImageFileBuilder();
        Assert.assertNotNull(imageFileBuilder.build(FileTestHelper.getMockFile("image.jpg")));
    }
}
