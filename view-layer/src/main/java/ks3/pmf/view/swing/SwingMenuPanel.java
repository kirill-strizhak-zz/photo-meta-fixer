package ks3.pmf.view.swing;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import ks3.pmf.boundary.Application;
import ks3.pmf.boundary.MenuPanel;

public class SwingMenuPanel extends MenuPanel<Component> {
    
    private final Component component;
    
    public SwingMenuPanel(Application app) {
        super(app);
        JPanel menuPanel = new JPanel(new BorderLayout());
        menuPanel.add(createMainMenu(), BorderLayout.NORTH);
        component = SwingUtils.wrapInScrollPane(menuPanel, null);
    }
    
    private Component createMainMenu() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createLoadFolderMenuItem());
        return menuBar;
    }
    
    private Component createLoadFolderMenuItem() {
        JMenuItem menuItem = new JMenuItem("Load Folder");
        menuItem.addActionListener(ev -> {
            System.out.println("open file menu");
        });
        return menuItem;
    }

    @Override
    public Component getComponent() {
        return component;
    }

}
