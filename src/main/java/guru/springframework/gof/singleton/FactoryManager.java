package guru.springframework.gof.singleton;

public class FactoryManager {

    private static FactoryManager instance = null;

    private static int numTracks = 5;

    private FactoryManager() {
    }

    public static FactoryManager getInstance() {
        if (instance == null) {
            instance = new FactoryManager();
        }
        return instance;
    }

    public static void startTracks() {
        for (int i = 0; i < numTracks; ++i) {
            Track t = new Track();
            t.start();
        }
    }

    static class Track implements Runnable {

        @Override
        public void run() {

        }

        public void start() {

        }
    }
}