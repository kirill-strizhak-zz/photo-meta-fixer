package ks3.pmf.view.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import ks3.pmf.view.ImagePanel;

public class SwingImagePanel implements ImagePanel<Component> {
    
    private final JPanel panel;
    private final Component outerComponent;
    private final List<ImageIcon> imageList = new ArrayList<>();
    
    public SwingImagePanel() {
        panel = new JPanel(new GridLayout(2, 2, 5, 5));
        JPanel imgFitPan = new JPanel();
        imgFitPan.add(panel, BorderLayout.WEST);
        JScrollPane imageScrollPane = new JScrollPane(imgFitPan);
        imageScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outerComponent = imageScrollPane;
    }
    
    protected JPanel getPanel() {
        return panel;
    }

    @Override
    public Component getComponent() {
        return outerComponent;
    }

    @Override
    public void addImage(ImageIcon imageIcon) {
        imageList.add(imageIcon);
    }

    @Override
    public List<ImageIcon> getImageList() {
        return Collections.unmodifiableList(imageList);
    }

}
