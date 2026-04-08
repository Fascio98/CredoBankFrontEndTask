package Utils;

import org.testng.annotations.DataProvider;

public class DataProviderImplementation {
        @DataProvider(name = "languages")
        public Object[][] languages() {
            return new Object[][]{
                    {Constants.Language.GEORGIAN.getLanguage()},
                    {Constants.Language.SVAN.getLanguage()}
            };
        }
}
