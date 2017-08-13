package ks3.pmf.boundary;

public interface MainWindow<T, U> {
    
    public abstract void show();
    public abstract void addImagePanel(ImagePanel<T, U> imagePanel);
    public abstract void addMenuPanel(MenuPanel<T> menuPanel);

}
