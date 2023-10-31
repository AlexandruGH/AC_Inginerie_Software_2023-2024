package WhySingletonBad;

public class SingletonExample {

    private static SingletonExample singleton;

    public static SingletonExample getInstance() {
        if (singleton == null) {
            singleton = new SingletonExample();
        }
        return singleton;
    }

    public void doStuff() {
        System.out.println("Doing stuff");
    }

}
