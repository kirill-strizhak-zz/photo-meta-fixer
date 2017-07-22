package ks3.pmf.model;

public class Application {
    
    private static Application instance;

    public static void initialize() {
        instance = new Application();
    }

}
