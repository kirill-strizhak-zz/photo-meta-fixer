package ks3.pmf.view.swing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
        assertEquals(4, imagePanel.calculateOptimalColumnCount(99));
    }
    
    @Ignore
    @Test
    public void testHandleResizeEvent() {
        //TODO: Figure out how to test resize event after recent changes to col count calculation
    }
}
