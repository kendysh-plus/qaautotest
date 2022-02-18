package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;

import static logger.CustomLogger.logger;

public class SelenoidConfig {
    public void createWebDriverInstance(String browser) {
        if (browser.equals("${BROWSER}")) {
            browser = "Chrome";
        }
        if (browser.equals("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        }
        Configuration.browser = browser;
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.timeout = 20000;
        Configuration.reportsFolder = "target/screenshots";
        Configuration.browserSize = "1920x1080";
        Configuration.browserCapabilities.setCapability("enableVNC", false);
        Configuration.browserCapabilities.setCapability("enableVideo", false);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        logger.info("ok");
    }
}
