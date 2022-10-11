package org.demo;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.demo.Pages.Pages.Entrypoint.SPORTS_PREMATCH;
import static org.demo.Pages.Pages.openPage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@Execution(ExecutionMode.CONCURRENT)
public class Test2 extends BaseTest{

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
    void testPosetive_1(){
        List<String> leftMenuItems = openPage(SPORTS_PREMATCH).getNavigationSliderItems();
        assertThat(leftMenuItems.size()).isGreaterThan(0);
    }

    @Test
    @Description("some desc")
    @Owner("vsoloviov@gmail.com")
    @Issue("JIRA-001")
    @TmsLink("TMS-001")
    void testPosetive_2(){
        List<String> leftMenuItems = openPage(SPORTS_PREMATCH).getNavigationSliderItems();
        assertThat(leftMenuItems.size()).isGreaterThan(0);
    }

    @Test
    @Description("some desc")
    @Owner("vsoloviov@gmail.com")
    @Issue("JIRA-001")
    @TmsLink("TMS-001")
    void testPosetive_3(){
        List<String> leftMenuItems = openPage(SPORTS_PREMATCH).getNavigationSliderItems();
        assertThat(leftMenuItems.size()).isGreaterThan(0);
    }
}
