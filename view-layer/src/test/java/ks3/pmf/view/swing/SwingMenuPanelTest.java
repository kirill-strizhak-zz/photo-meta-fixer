package ks3.pmf.view.swing;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import ks3.pmf.boundary.Application;

public class SwingMenuPanelTest {

    private Application app;
    
    @Test
    public void canCreateAndGetComponent() {
        app = Mockito.mock(Application.class);
        assertNotNull(new SwingMenuPanel(app).getComponent());
    }
    
    @Ignore
    @Test
    public void testCanPickFolderToLoad() {
        
    }

}
