package ks3.pmf.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import ks3.pmf.model.awt.RunAllAwtTests;
import ks3.pmf.model.loaders.RunAllLoaderTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    RunAllAwtTests.class,
    RunAllLoaderTests.class
})
public class RunAllModelTests {
    
}