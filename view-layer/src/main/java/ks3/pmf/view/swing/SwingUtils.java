package ks3.pmf.view.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ComponentAdapter;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class SwingUtils {
    
    private SwingUtils() {
        
    }

    public static Component wrapInScrollPane(Component content, ComponentAdapter resizeListener) {
        JPanel fitPan = new JPanel();
        fitPan.add(content, BorderLayout.WEST);
        JScrollPane scrollPane = new JScrollPane(fitPan);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        if (resizeListener != null) {
            scrollPane.addComponentListener(resizeListener);
        }
        return scrollPane;
    }
}
