package CreationalSingleton;

public class Singleton {
    // Private static instance of the singleton class
    private static Singleton instance;

    // Private constructor to restrict instantiation from other classes
    private Singleton() {}

    // Public method to provide access to the singleton instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello World! This is a Singleton instance.");
    }
}