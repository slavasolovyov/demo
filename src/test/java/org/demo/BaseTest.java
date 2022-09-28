package org.demo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.demo.config.TestConfiguration;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseTest {

    static {
        setupSelenide();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .includeSelenideSteps(false)
                .screenshots(false)
                .savePageSource(false));
    }
    private static void setupSelenide() {
        Configuration.screenshots = false;
        Configuration.savePageSource = false;
        Configuration.baseUrl = TestConfiguration.BASE_URL;
        Configuration.timeout = 60000;
        Configuration.pageLoadTimeout = 60000;
        Configuration.browserSize = "1920x1080";
        Configuration.fileDownload = FileDownloadMode.FOLDER;
        if (!TestConfiguration.USE_LOCAL_BROWSER) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setHeadless(false);
            chromeOptions.addArguments("--no-sandbox", "--disable-gpu", "window-size=1920,1080", "--disable-dev-shm-usage");
            chromeOptions.setCapability("browserName", "chrome");
            chromeOptions.setCapability("enableVNC", true);
            chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            Configuration.browserCapabilities = chromeOptions;
            Configuration.remote = TestConfiguration.SELENOID_URL;
        }
    }
}