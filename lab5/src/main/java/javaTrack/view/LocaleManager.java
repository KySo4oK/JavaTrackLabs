package javaTrack.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleManager {
    private static final String BUNDLE_NAME = "messages";
    private final ResourceBundle resourceBundle;

    LocaleManager(Locale locale) {
        this.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
    }

    public String getString(String key) {
        return resourceBundle.getString(key);
    }
}
