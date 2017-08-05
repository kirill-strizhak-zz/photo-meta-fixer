package ks3.pmf.view.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import ks3.pmf.model.ImageFile;
import ks3.pmf.view.ImageItem;

public class SwingImageItem implements ImageItem<Component> {
    
    private final ImageFile<Image> imageFile;
    private final JPanel component;
    
    private JLabel image;
    private JLabel label;
    
    public SwingImageItem(ImageFile<Image> imageFile) {
        this.imageFile = imageFile;
        component = new JPanel(new BorderLayout());
        createImageIcon();
        createLabelWithGeneratedName();
        createBorderWithFileName();
    }

    private void createImageIcon() {
        ImageIcon imageIcon = new ImageIcon(imageFile.getIcon());
        image = new JLabel("", imageIcon, JLabel.CENTER);
        component.add(image, BorderLayout.CENTER);
    }

    private void createLabelWithGeneratedName() {
        label = new JLabel(imageFile.getGeneratedName());
        component.add(label, BorderLayout.SOUTH);
    }

    private void createBorderWithFileName() {
        Border lineBorder = BorderFactory.createLineBorder(Color.GRAY, 1);
        Border titleBorder = BorderFactory.createTitledBorder(lineBorder, imageFile.getFileName(), TitledBorder.CENTER, TitledBorder.TOP);
        component.setBorder(titleBorder);
    }

    @Override
    public Component getComponent() {
        return component;
    }

}
