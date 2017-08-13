package ks3.pmf.view.swing;

import java.awt.Component;

import javax.swing.JPanel;

import ks3.pmf.boundary.Application;
import ks3.pmf.boundary.MenuPanel;

public class SwingMenuPanel extends MenuPanel<Component> {
    
    private final Component component;
    
    public SwingMenuPanel(Application app) {
        super(app);
        component = new JPanel();
    }

    @Override
    public Component getComponent() {
        return component;
    }

}
