package ks3.pmf;

import ks3.pmf.boundary.Application;
import ks3.pmf.boundary.Setting;
import ks3.pmf.boundary.Settings;
import ks3.pmf.view.swing.SwingApplication;

public class InterfaceTest {

    public static void main(String[] args) throws Exception {
        Application app = SwingApplication.getInstance();

        int targetWidth = Settings.getInteger(Setting.IMAGE_ICON_WIDTH);
        int targetHeight = Settings.getInteger(Setting.IMAGE_ICON_HEIGHT);
    }
}
