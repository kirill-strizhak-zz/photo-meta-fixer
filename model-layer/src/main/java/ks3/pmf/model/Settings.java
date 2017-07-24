package ks3.pmf.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class Settings {

    @SuppressWarnings("serial")
    private static class FailedToWriteFile extends RuntimeException {

    }

    @SuppressWarnings("serial")
    private class FailedToReadFile extends RuntimeException {

    }

    private static Settings instance;

    private final String filePath;
    private final Properties props;

    private Settings(String filePath) {
        this.filePath = filePath;
        this.props = new Properties();
    }

    public static void initialize(String filePath) {
        if (instance == null) {
            instance = new Settings(filePath);
        }
        instance.load();
    }

    public static String get(String name) {
        return instance.props.getProperty(name);
    }
    
    public static String get(Setting name) {
        return get(name.toString());
    }

    public static Integer getInteger(String name) {
        String value = get(name);
        if (value == null) {
            return null;
        } else {
            return Integer.parseInt(value);
        }
    }
    
    public static Integer getInteger(Setting name) {
        return getInteger(name.toString());
    }

    public static void set(String name, Object value) {
        instance.props.setProperty(name, value.toString());
    }

    public static void set(Setting name, Object value) {
        set(name.toString(), value);
    }

    public static void save() {
        instance.tryToSave();
    }

    private void tryToSave() {
        try {
            FileOutputStream outStream = new FileOutputStream(filePath);
            props.storeToXML(outStream, generateComment());
            outStream.close();
        } catch (IOException ex) {
            throw new Settings.FailedToWriteFile();
        }
    }

    private String generateComment() {
        return String.format("Last saved on %1$tF %1$tT %1$tz", new Date());
    }

    protected static void reload() {
        instance.load();
    }

    private void load() throws Settings.FailedToReadFile {
        File file = new File(filePath);
        if (file.exists()) {
            tryToLoadFile(file);
        } else {
            loadDefaultSettings();
        }
    }

    private void tryToLoadFile(File file) {
        try {
            FileInputStream inStream = new FileInputStream(file);
            props.loadFromXML(inStream);
            inStream.close();
        } catch (IOException ex) {
            throw new Settings.FailedToReadFile();
        }
    }

    private void loadDefaultSettings() {
        File file = lookupDefaultSettingFile();
        if (file.exists()) {
            tryToLoadFile(file);
        }
    }

    private File lookupDefaultSettingFile() {
        File file = new File("../model-layer/resources/default_settings.xml");
        // TODO: Lookup file in packaged application
        return file;
    }

}
