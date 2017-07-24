package ks3.pmf.view.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import ks3.pmf.view.ImagePanel;

public class SwingImagePanel implements ImagePanel<Component> {
    
    private final JPanel panel;
    private final Component outerComponent;
    
    public SwingImagePanel() {
        panel = new JPanel(new GridLayout(2, 2, 5, 5));
        JPanel imgFitPan = new JPanel();
        imgFitPan.add(panel, BorderLayout.WEST);
        JScrollPane imageScrollPane = new JScrollPane(imgFitPan);
        imageScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outerComponent = imageScrollPane;
    }

    public Component getComponent() {
        return outerComponent;
    }

}
