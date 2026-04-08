package Utils;

public class Constants {
    public enum Language {
        GEORGIAN("ქართული"),
        SVAN("სვანური");

        private final String language;

        Language(String language) {
            this.language = language;
        }

        public String getLanguage() {
            return language;
        }
    }
}
