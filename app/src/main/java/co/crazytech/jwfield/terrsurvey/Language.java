package co.crazytech.jwfield.terrsurvey;

/**
 * Created by eric on 12/8/2015.
 */
public class Language {
    private String locale,name,basename;

    public Language(String locale, String name, String basename) {
        this.locale = locale;
        this.name = name;
        this.basename = basename;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBasename() {
        return basename;
    }

    public void setBasename(String basename) {
        this.basename = basename;
    }
}
