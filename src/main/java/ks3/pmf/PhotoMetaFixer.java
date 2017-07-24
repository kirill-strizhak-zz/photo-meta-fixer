package ks3.pmf;

import ks3.pmf.model.Settings;
import ks3.pmf.view.Application;

public class PhotoMetaFixer {

    public static void main(String[] args) {
        Settings.initialize("./settings.xml");
        Application.initialize();
    }

}
