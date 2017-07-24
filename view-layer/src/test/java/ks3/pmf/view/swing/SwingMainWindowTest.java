package ks3.pmf.view.swing;

import java.awt.Component;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ks3.pmf.model.Settings;
import ks3.pmf.view.MainWindow;
import ks3.pmf.view.swing.SwingImagePanel;
import ks3.pmf.view.swing.SwingMainWindow;

public class SwingMainWindowTest {
    
    private MainWindow<Component, ComponentListener> mainFrame;

    @Before
    public void setUp() {
        Settings.initialize("./settings.xml");
        mainFrame = new SwingMainWindow();
    }
    
    @Test
    public void canShow() {
        mainFrame.show();
    }
    
    @Test
    public void canAddImagePanel() {
        mainFrame.addImagePanel(new SwingImagePanel());
    }
    
    @Test
    public void canAddListeners() {
        List<ComponentListener> listenerList = new ArrayList<>();
        mainFrame.addListener(listenerList);
    }

}
