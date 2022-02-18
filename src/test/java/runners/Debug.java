package runners;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Debug {

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        Configuration.timeout = 30000;
        Configuration.browserSize = "1920x1080";
    }

    @AfterMethod(alwaysRun = true)
    void tearDown() {
        Selenide.closeWebDriver();
    }

}
