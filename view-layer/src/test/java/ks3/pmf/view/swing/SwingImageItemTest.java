package ks3.pmf.view.swing;

import static org.junit.Assert.assertEquals;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.junit.Test;

import ks3.pmf.model.awt.AwtImageFile;

public class SwingImageItemTest {

    @Test
    public void testCreateImageItem() {
        int width = 20;
        int height = 10;
        String fileName = "fileName";
        String generatedName = "generatedName";
        AwtImageFile imageFile = SwingTestsHelper.getMockImageFile(fileName, generatedName, width, height);
        
        SwingImageItem imageItem = new SwingImageItem(imageFile, width, height);
        validateBuiltImageItem(imageItem, fileName, generatedName, width, height);
    }

    private void validateBuiltImageItem(SwingImageItem imageItem, String fileName, String generatedName, int width, int height) {
        JPanel component = (JPanel)imageItem.getComponent();
        Dimension maxSize = component.getComponent(0).getMaximumSize();
        Dimension minSize = component.getComponent(0).getMinimumSize();
        assertEquals(width, (int)maxSize.getWidth());
        assertEquals(width, (int)minSize.getWidth());
        assertEquals(height, (int)maxSize.getHeight());
        assertEquals(height, (int)minSize.getHeight());
        
        TitledBorder border = (TitledBorder)component.getBorder();
        assertEquals(fileName, border.getTitle());
        
        JLabel generated = (JLabel)component.getComponent(1);
        assertEquals(generatedName, generated.getText());
    }

}
