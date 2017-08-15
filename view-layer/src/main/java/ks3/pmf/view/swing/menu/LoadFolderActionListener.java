package ks3.pmf.view.swing.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import ks3.pmf.boundary.MenuPanel;

@SuppressWarnings("rawtypes")
class LoadFolderActionListener implements ActionListener {

    private static final String DEFAULT_FOLDER = "C:\\Users\\ks3\\Google Drive\\Google Photos\\2016";
    
    private final MenuPanel menuPanel;
    private final JFileChooser folderChooser;
    
    public LoadFolderActionListener(MenuPanel menuPanel) {
        this.menuPanel = menuPanel;
        folderChooser = new JFileChooser(DEFAULT_FOLDER);
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }
    
    @Override
    public void actionPerformed(ActionEvent ev) {
        if (userSelectsFolder()) {
            menuPanel.loadAllImages(folderChooser.getSelectedFile().getAbsolutePath());
        }
    }
    
    protected boolean userSelectsFolder() {
        return JFileChooser.APPROVE_OPTION == folderChooser.showOpenDialog(null);
    }
}
