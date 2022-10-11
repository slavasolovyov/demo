package org.demo;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.demo.Pages.Pages.Entrypoint.AUTH_PAGE;
import static org.demo.Pages.Pages.Entrypoint.SPORTS_PREMATCH;
import static org.demo.Pages.Pages.openPage;
import static org.demo.config.TestConfiguration.MOBILE;
import static org.demo.config.TestConfiguration.SELENOID_URL;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.sskorol.cdt.protocol.commands.Emulation;
import io.github.sskorol.cdt.services.ChromeDevToolsService;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import lombok.SneakyThrows;
import org.demo.Pages.user.PrematchPage;
import org.demo.config.TestConfiguration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test1 extends BaseTest{

    @BeforeAll
    @SneakyThrows
    void setUp(){
        login();
    }

    @Test
    @Description("some desc")
    @Owner("vsoloviov@gmail.com")
    @Issue("JIRA-001")
    @TmsLink("TMS-001")
    void testNegative(){
        List<String> leftMenuItems = openPage(SPORTS_PREMATCH).getNavigationSliderItems();
        assertThat(leftMenuItems.size()).isGreaterThan(0);
        assertThat(leftMenuItems.contains("123")).isTrue();

    }
    @Test
    @Description("some desc")
    @Owner("vsoloviov@gmail.com")
    @Issue("JIRA-001")
    @TmsLink("TMS-001")
    void testPosetive(){
        List<String> leftMenuItems = openPage(SPORTS_PREMATCH).getNavigationSliderItems();
        assertThat(leftMenuItems.size()).isGreaterThan(0);
    }
}
