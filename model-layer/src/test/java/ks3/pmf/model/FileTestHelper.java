package ks3.pmf.model;

import java.io.File;

import org.mockito.Mockito;

public class FileTestHelper {
    
    public static File getMockFile(String name) {
        return FileTestHelper.getMockFile(name, false);
    }

    public static File getMockFile(String name, boolean isFolder) {
        File file = Mockito.mock(File.class);
        Mockito.when(file.isDirectory()).thenReturn(isFolder);
        Mockito.when(file.getName()).thenReturn(name);
        return file;
    }
}
