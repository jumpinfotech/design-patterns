package guru.springframework.gof.singleton;

public class SingletonClassLazyInitialization {

    private static SingletonClassLazyInitialization instance = null;

    private SingletonClassLazyInitialization() {
    }

    public static SingletonClassLazyInitialization getInstance() {
        if (instance == null) {
            instance = new SingletonClassLazyInitialization();
        }
        return instance;
    }
}