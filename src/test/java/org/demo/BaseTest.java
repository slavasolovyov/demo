package org.demo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.WebDriverConditions;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.sskorol.cdt.protocol.commands.Emulation;
import io.github.sskorol.cdt.services.ChromeDevToolsService;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.SneakyThrows;
import org.demo.Pages.GoogleAuthPage;
import org.demo.config.BaseLogger;
import org.demo.config.TestConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.webdriver;
import static java.lang.String.format;
import static org.demo.Pages.Pages.Entrypoint.AUTH_PAGE;
import static org.demo.Pages.Pages.openPage;
import static org.demo.config.TestConfiguration.MOBILE;

@ExtendWith({BaseLogger.class})
public class BaseTest {

    private static org.demo.config.Configuration.Config config = org.demo.config.Configuration.getConfig();
    protected org.demo.config.Configuration.TestDataConfig testData = config.getTestDataConfig();

    static {
        setupSelenide();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .includeSelenideSteps(false)
                .screenshots(false)
                .savePageSource(false));
    }
    @SneakyThrows
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

    @SneakyThrows
    public void login(){
        GoogleAuthPage authPage = openPage(AUTH_PAGE);
//        if (MOBILE){
//            RemoteWebDriver driver = (RemoteWebDriver) WebDriverRunner.getWebDriver();
//            String path = TestConfiguration.SELENOID_URL.replace("http", "ws").replace("/wd/hub", "");
//            ChromeDevToolsService chromeDevTools = ChromeDevToolsService.from(format(path + "/devtools/%s/page", driver.getSessionId()));
//            Emulation emulation = chromeDevTools.getEmulation();
//            emulation.setDeviceMetricsOverride(390,
//                    844,
//                    100d,
//                    true);
//        }
        authPage
                .setLogin(testData.getLogin())
                .clickOnNext()
                .setPassword(testData.getPass())
                .clickOnNext();
        webdriver().shouldHave(WebDriverConditions.urlContaining(testData.getBaseUrl()), Duration.ofSeconds(60));
    }

}