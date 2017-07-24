package ks3.pmf.view.swing;

import static org.junit.Assert.*;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ks3.pmf.view.ImagePanel;
import ks3.pmf.view.swing.SwingImagePanel;

public class SwingImagePanelTest {
    
    private ImagePanel<Component> imagePanel;

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
        ImageIcon icon = new ImageIcon();
        imagePanel.addImage(icon);
        assertTrue(imagePanel.getImageList().contains(icon));
    }
    
    @Ignore
    @Test
    public void testHandleResizeEvent() {
        assertExpectedResizeOutcome(200, 100, 2, 2);
        assertExpectedResizeOutcome(400, 200, 4, 2);
    }

    private void assertExpectedResizeOutcome(int width, int height, int rows, int cols) {
        JPanel panel = ((SwingImagePanel) imagePanel).getPanel();
        panel.setSize(width, height);
        assertEquals(rows, ((GridLayout) panel.getLayout()).getRows());
        assertEquals(cols, ((GridLayout) panel.getLayout()).getColumns());
    }

}
