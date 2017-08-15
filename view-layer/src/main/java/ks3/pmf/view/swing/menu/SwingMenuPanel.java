package ks3.pmf.view.swing.menu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import ks3.pmf.boundary.Application;
import ks3.pmf.boundary.MenuPanel;
import ks3.pmf.view.swing.SwingUtils;

public class SwingMenuPanel extends MenuPanel<Component> {

    private final Component component;
    private final ActionListener loadFolderListener;
    
    private JMenuItem loadFolderMenuItem;
    
    public SwingMenuPanel(Application app) {
        this(app, null);
    }
    
    protected SwingMenuPanel(Application app, ActionListener loadFolderListener) {
        super(app);
        this.loadFolderListener = (loadFolderListener == null) ? new LoadFolderActionListener(this) : loadFolderListener;
        
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
        loadFolderMenuItem = new JMenuItem("Load Folder");
        loadFolderMenuItem.addActionListener(loadFolderListener);
        return loadFolderMenuItem;
    }

    @Override
    public Component getComponent() {
        return component;
    }
    
    protected JMenuItem getLoadFolderMenuItem() {
        return loadFolderMenuItem;
    }

}
