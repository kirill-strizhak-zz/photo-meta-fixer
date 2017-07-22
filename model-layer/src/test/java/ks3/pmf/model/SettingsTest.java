package ks3.pmf.model;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SettingsTest {
    
    private static final String FILE_PATH = "./test_settings.xml";

    @Before
    public void setUp() {
        deleteTestFile();
        Settings.initialize(FILE_PATH);
    }
    
    @After
    public void tearDown() {
        deleteTestFile();
    }
    
    @Test
    public void testSavingToFile_PersistsValues() {
        String settingName = "testSaving";
        String value = saveRandomValue(settingName);
        Settings.reload();
        assertEquals(value, Settings.get(settingName));
    }
    
    @Test
    public void testLoadingFromFile_ResetsUnsavedChanges() {
        String settingName = "testLoading";
        String value = saveRandomValue(settingName);
        Settings.set(settingName, "other value");
        Settings.reload();
        assertEquals(value, Settings.get(settingName));
    }
    
    @Test
    public void testLoadingDefaultSettings() {
        assertEquals("Photo Meta Fixer", Settings.get("applicationName"));
    }

    private boolean deleteTestFile() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            return file.delete();
        } else {
            return true;
        }
    }

    private String saveRandomValue(String settingName) {
        String value = String.valueOf(System.currentTimeMillis());
        Settings.set(settingName, value);
        Settings.save();
        return value;
    }

}
