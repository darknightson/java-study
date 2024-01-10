package effectivejava.chapter1;

public class Settings {

    private boolean useAutoSteering;
    private boolean useAbs;

    private Settings() {}

    private static final Settings SETTINGS = new Settings();

    public static Settings getInstance() {
        return SETTINGS;
    }
}
