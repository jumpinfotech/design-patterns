package guru.springframework.gof.singleton;

public class SingletonClassEagerInitialization {

    private static final SingletonClassEagerInitialization INSTANCE = new SingletonClassEagerInitialization();

    private SingletonClassEagerInitialization() {
    }

    public static SingletonClassEagerInitialization getInstance() {
        return INSTANCE;
    }
}