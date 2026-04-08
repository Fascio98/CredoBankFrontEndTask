package Utils;

import org.testng.annotations.DataProvider;

public class DataProviderImplementation {
    
    // Private constructor to prevent instantiation
    private DataProviderImplementation() {
        throw new UnsupportedOperationException("Utility class - do not instantiate");
    }
    
    @DataProvider(name = "languages")
    public static Object[][] languages() {
        return new Object[][]{
                {Constants.Language.GEORGIAN.getLanguage()},
                {Constants.Language.SVAN.getLanguage()}
        };
    }
}
