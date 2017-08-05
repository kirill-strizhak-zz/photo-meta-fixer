package ks3.pmf.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ks3.pmf.model.loader.RunAllLoaderTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    SettingsTest.class,
    RunAllLoaderTests.class
})
public class RunAllModelTests {
    
}