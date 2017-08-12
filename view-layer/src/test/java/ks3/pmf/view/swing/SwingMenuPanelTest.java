package ks3.pmf.view.swing;

import static org.junit.Assert.*;

import org.junit.Test;

public class SwingMenuPanelTest {

    @Test
    public void canCreateAndGetComponent() {
        assertNotNull(new SwingMenuPanel().getComponent());
    }

}
