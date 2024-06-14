package CreationalSingleton;

public class SingletonPatternDemo {
    public static void main(String[] args) {
        // Get the only object available
        Singleton singleInstance = Singleton.getInstance();

        // Show the message
        singleInstance.showMessage();
    }
}