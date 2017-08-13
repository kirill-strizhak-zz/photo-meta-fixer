package ks3.pmf.view.swing;

import ks3.pmf.boundary.Application;

public class SwingApplication extends Application {
    
    private static SwingApplication instance;
    
    protected SwingApplication() {
        super(SwingMainWindow.class, SwingImagePanel.class, SwingMenuPanel.class);
    }

    public static SwingApplication getInstance() {
        if (instance == null) {
            instance = new SwingApplication();
        }
        return instance;
    }

}
