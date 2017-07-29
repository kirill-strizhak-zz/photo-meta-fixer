package ks3.pmf.view.swing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ks3.pmf.model.Setting;
import ks3.pmf.model.Settings;

public class SwingImagePanelTest {
    
    private SwingImagePanel imagePanel;

    @Before
    public void setUp() {
        Settings.initialize("./settings");
        Settings.set(Setting.IMAGE_ICON_WIDTH, 20);
        imagePanel = new SwingImagePanel();
    }
    
    @Test
    public void testOuterComponentIsInitialized() {
        assertNotNull(imagePanel.getComponent());
    }
    
    @Test
    public void testAddingImage() {
        imagePanel.addImage(SwingTestsHelper.getMockImageFile());
        assertEquals(1, imagePanel.getImageList().size());
    }
    
    @Test
    public void testIsEmpty() {
        assertTrue(imagePanel.isEmpty());
        imagePanel.addImage(SwingTestsHelper.getMockImageFile());
        assertFalse(imagePanel.isEmpty());
    }
    
    @Test
    public void testCalculateOptimalColumnCount() {
        assertEquals(5, imagePanel.calculateOptimalColumnCount(100));
        //TODO: look for edge cases
    }
    
    @Test
    public void testHandleResizeEvent() {
        imagePanel.addImage(SwingTestsHelper.getMockImageFile());
        assertExpectedResizeOutcome(200, 100, 10);
        assertExpectedResizeOutcome(400, 200, 20);
    }
    
    @Ignore
    @Test
    public void testUpdateItemDimension() {
        //TODO: meaningful init
        imagePanel.updateItemDimensions(5, 5);
        //TODO: validation
    }

    private void assertExpectedResizeOutcome(int width, int height, int cols) {
        Component component = imagePanel.getComponent();
        component.setSize(width, height);
        component.dispatchEvent(new ComponentEvent(component, ComponentEvent.COMPONENT_RESIZED));

        GridLayout layout = (GridLayout) imagePanel.getPanel().getLayout();
        assertEquals(cols, layout.getColumns());
    }

}
