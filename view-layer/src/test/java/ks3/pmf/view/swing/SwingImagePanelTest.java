package ks3.pmf.view.swing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JPanel;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ks3.pmf.model.awt.AwtImageFile;
import ks3.pmf.view.ImagePanel;

public class SwingImagePanelTest {
    
    private ImagePanel<Component, Image> imagePanel;

    @Before
    public void setUp() {
        imagePanel = new SwingImagePanel();
    }
    
    @Test
    public void testOuterComponentIsInitialized() {
        assertNotNull(imagePanel.getComponent());
    }
    
    @Test
    public void testAddingImage() {
        AwtImageFile imageFile = SwingTestsHelper.getMockImageFile();
        imagePanel.addImage(imageFile);
        assertEquals(1, imagePanel.getImageList().size());
    }
    
    @Ignore
    @Test
    public void testHandleResizeEvent() {
        assertExpectedResizeOutcome(200, 100, 2, 2);
        assertExpectedResizeOutcome(400, 200, 4, 2);
    }
    
    @Ignore
    @Test
    public void testUpdateItemDimension() {
        //TODO: meaningful init
        imagePanel.updateItemDimensions(5, 5);
        //TODO: validation
    }

    private void assertExpectedResizeOutcome(int width, int height, int rows, int cols) {
        JPanel panel = ((SwingImagePanel) imagePanel).getPanel();
        panel.setSize(width, height);
        assertEquals(rows, ((GridLayout) panel.getLayout()).getRows());
        assertEquals(cols, ((GridLayout) panel.getLayout()).getColumns());
    }

}
