package ks3.pmf.view.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import ks3.pmf.model.ImageFile;
import ks3.pmf.model.Setting;
import ks3.pmf.model.Settings;
import ks3.pmf.view.ImageItem;
import ks3.pmf.view.ImagePanel;

public class SwingImagePanel implements ImagePanel<Component, Image> {
    
    private class ImagePanelResizeListener extends ComponentAdapter {

        @Override
        public void componentResized(ComponentEvent ev) {
            System.out.println(ev.getSource());
        }

    }

    private final JPanel panel;
    private final Component outerComponent;
    private final List<SwingImageItem> imageList = new ArrayList<>();
    
    private int iconWidth;
    private int iconHeight;
    
    public SwingImagePanel() {
        panel = new JPanel(new GridLayout(0, 2, 5, 5));
        panel.addComponentListener(new ImagePanelResizeListener());
        
        JPanel imgFitPan = new JPanel();
        imgFitPan.add(panel, BorderLayout.WEST);
        JScrollPane imageScrollPane = new JScrollPane(imgFitPan);
        imageScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outerComponent = imageScrollPane;
        
        iconWidth = Settings.getInteger(Setting.IMAGE_ICON_WIDTH);
        iconHeight = Settings.getInteger(Setting.IMAGE_ICON_HEIGHT);
    }

    @Override
    public Component getComponent() {
        return outerComponent;
    }

    @Override
    public void addImage(ImageFile<Image> imageFile) {
        imageList.add(new SwingImageItem(imageFile, iconWidth, iconHeight));
    }

    @Override
    public List<ImageItem<Component>> getImageList() {
        return Collections.unmodifiableList(imageList);
    }

    @Override
    public void updateItemDimensions(int width, int height) {
        // TODO Auto-generated method stub
    }
    
    protected JPanel getPanel() {
        return panel;
    }

    protected boolean isEmpty() {
        return imageList.isEmpty();
    }

    protected int calculateOptimalColumnCount(int newWidth) {
        int colCount = Math.floorDiv(newWidth, iconWidth);
        return (colCount < 1) ? 1 : colCount;
    }

}
