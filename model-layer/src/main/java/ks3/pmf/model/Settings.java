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
        instance = new Settings(filePath);
        instance.load();
    }

    public static String get(String name) {
        return instance.props.getProperty(name);
    }

    public static void set(String name, String value) {
        instance.props.setProperty(name, value);
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
        //TODO: Lookup file in packaged application
        File file = new File("./resources/default_settings.xml");
        if (file.exists()) {
            tryToLoadFile(file);
        }
    }

}
