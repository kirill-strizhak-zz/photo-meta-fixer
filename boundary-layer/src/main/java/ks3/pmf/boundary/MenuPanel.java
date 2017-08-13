package ks3.pmf.boundary;

public abstract class MenuPanel<T> implements ComponentContainer<T> {
    
    private final Application app;

    public MenuPanel(Application app) {
        this.app = app;
    }
    
    public void loadAllImages(String path) {
        app.loadAllImages(path);
    }
}
