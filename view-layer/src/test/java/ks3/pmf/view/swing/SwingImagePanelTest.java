package ks3.pmf.view.swing;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.junit.Before;
import org.junit.Test;

import ks3.pmf.data.ImageFile;

public class SwingImagePanelTest {
    
    private JPanel panel;
    private Component imageItem;
    private SwingImagePanel imagePanel;

    @Before
    public void setUp() {
        imageItem = mock(Component.class);
        when(imageItem.getWidth()).thenReturn(20);
        
        panel = spy(JPanel.class);
        panel.setLayout(new GridLayout(0, 2, 5, 5));
        panel.add(new JLabel());
        when(panel.getComponent(eq(0))).thenReturn(imageItem);
        
        imagePanel = new SwingImagePanel(panel);
    }
    
    @Test
    public void testOuterComponentIsInitialized() {
        assertNotNull(imagePanel.getComponent());
    }
    
    @Test
    @SuppressWarnings("unchecked")
    public void testAddingImage() {
        @SuppressWarnings("rawtypes")
        ImageFile imageFile = SwingTestsHelper.getMockImageFile();
        imagePanel.addImage(imageFile);
        imagePanel.refreshImageDisplay();
        assertEquals(1, imagePanel.getImageList().size());
        assertEquals(1, panel.getComponentCount());
        
        JPanel imageItem = (JPanel) panel.getComponents()[0];
        TitledBorder border = (TitledBorder) imageItem.getBorder();
        assertEquals(imageFile.getFileName(), border.getTitle());
    }
    
    @Test
    @SuppressWarnings("unchecked")
    public void testAddRemoveImage() {
        assertTrue(imagePanel.getImageList().isEmpty());
        imagePanel.addImage(SwingTestsHelper.getMockImageFile());
        assertFalse(imagePanel.getImageList().isEmpty());
    }
    
    @Test
    public void testCalculateOptimalColumnCount() {
        assertEquals(5, imagePanel.calculateOptimalColumnCount(100));
        assertEquals(4, imagePanel.calculateOptimalColumnCount(99));
    }
    
    @Test
    public void givenPanelWithItems_handleResizeEvent() {
        assertExpectedResizeOutcome(220, 100, 9);
        assertExpectedResizeOutcome(220, 100, 9);
        assertExpectedResizeOutcome(414, 200, 18);
        assertExpectedResizeOutcome(415, 200, 19);
    }
    
    @Test
    public void givenPanelWithoutItems_ignoreResizeEvent() {
        panel.removeAll();
        assertExpectedResizeOutcome(1000, 100, 2);
    }
    
    @Test
    public void givenWidthSmallerThanItems_ShouldHaveAtLeastOneColumn() {
        assertExpectedResizeOutcome(1, 100, 1);
    }

    private void assertExpectedResizeOutcome(int width, int height, int cols) {
        Component component = imagePanel.getComponent();
        component.setSize(width, height);
        component.dispatchEvent(new ComponentEvent(component, ComponentEvent.COMPONENT_RESIZED));

        GridLayout layout = (GridLayout) imagePanel.getPanel().getLayout();
        assertEquals(cols, layout.getColumns());
    }
}
