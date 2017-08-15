package ks3.pmf.view.swing.menu;

import static org.mockito.Mockito.*;

import java.awt.event.ActionListener;

import org.junit.Before;
import org.junit.Test;

import ks3.pmf.boundary.Application;

public class SwingMenuPanelTest {

    private SwingMenuPanel menuPanel;
    private Application app;
    private ActionListener actionListener;
    
    @Before
    public void setUp() {
        app = mock(Application.class);
        actionListener = ev -> {
            menuPanel.loadAllImages(".");
        };
        menuPanel = new SwingMenuPanel(app, actionListener);
    }
    
    @Test
    public void testCanPickFolderToLoad() {
        menuPanel.getLoadFolderMenuItem().doClick();
        verify(app, times(1)).loadAllImages(".");
    }

}
