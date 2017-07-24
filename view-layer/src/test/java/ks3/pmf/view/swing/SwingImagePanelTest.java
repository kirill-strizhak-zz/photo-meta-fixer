package ks3.pmf.view.swing;

import static org.junit.Assert.*;

import java.awt.Component;

import org.junit.Before;
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

}
