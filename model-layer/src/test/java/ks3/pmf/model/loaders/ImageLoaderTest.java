package ks3.pmf.model.loaders;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InOrder;

import ks3.pmf.data.ImageFile;
import ks3.pmf.model.ImageFileBuilder;

@SuppressWarnings("rawtypes")
public class ImageLoaderTest {
    
    private static final int WIDTH = 1;
    private static final int HEIGHT = 2;
    
    private static final String LOCATION = "../src/test/resources/images/two_basic_images";
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    private ImageLoader imageLoader;
    private ImageFileBuilder imageFileBuilder;
    private ImageFile mockFile;
    private Loader mockLoader;

    private List<ImageFile> loadWithDefault(String location) {
        mockFile = mock(ImageFile.class);
        when(imageFileBuilder.build(any(File.class), anyInt(), anyInt())).thenReturn(mockFile);
        List<ImageFile> files = imageLoader.loadAllImages(location);
        return files;
    }
    
    private void setUpCatchAllLoader() {
        mockLoader = mock(Loader.class);
        imageLoader.getLoaders().add(mockLoader);
        when(mockLoader.canLoadFrom(anyString())).thenReturn(true);
        
        List<ImageFile> mockList = new ArrayList<>();
        mockList.add(mockFile);
        when(mockLoader.loadAllImages(anyString())).thenReturn(mockList);
    }

    @Before
    public void setUp() {
        imageFileBuilder = mock(ImageFileBuilder.class);
        imageLoader = new ImageLoader(imageFileBuilder, WIDTH, HEIGHT);
    }
    
    @Test
    public void givenValidPath_fileSystemLoaderCalled() {
        List<ImageFile> files = loadWithDefault(LOCATION);
        assertEquals(2, files.size());
        assertSame(mockFile, files.get(0));
        assertSame(mockFile, files.get(1));
        verify(imageFileBuilder, times(2)).build(any(File.class), anyInt(), anyInt());
    }
    
    @Test
    public void afterDimensionUpdate_fileBuilderCalledWithCorrectDimensions() {
        loadWithDefault(LOCATION);
        verify(imageFileBuilder, times(2)).build(any(File.class), eq(WIDTH), eq(HEIGHT));
        imageLoader.setIconTargetDimensions(10, 11);
        loadWithDefault(LOCATION);
        verify(imageFileBuilder, times(2)).build(any(File.class), eq(10), eq(11));
    }
    
    @Test
    public void givenInvalidPath_exceptionThrown() {
        thrown.expect(ImageLoader.NoLoaderFoundError.class);
        imageLoader.loadAllImages("#");
    }
    
    @Test
    public void givenInvalidPath_catchAllLoaderCalled() {
        setUpCatchAllLoader();
        List<ImageFile> files = imageLoader.loadAllImages("#");
        assertEquals(1, files.size());
        assertSame(mockFile, files.get(0));
        InOrder inOrder = inOrder(mockLoader);
        inOrder.verify(mockLoader, times(1)).canLoadFrom(anyString());
        inOrder.verify(mockLoader, times(1)).loadAllImages(anyString());
    }
}
