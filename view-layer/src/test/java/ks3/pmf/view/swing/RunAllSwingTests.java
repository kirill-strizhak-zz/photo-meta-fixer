package ks3.pmf.view.swing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ks3.pmf.view.swing.menu.RunAllSwingMenuTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    SwingApplicationTest.class,
    SwingImageItemTest.class,
    SwingImagePanelTest.class,
    SwingMainWindowTest.class,
    RunAllSwingMenuTests.class
})
public class RunAllSwingTests {
    
}
