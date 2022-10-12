package org.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.demo.Pages.Pages.Entrypoint.SPORTS_PREMATCH;
import static org.demo.Pages.Pages.openPage;

import io.qameta.allure.*;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;


import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Execution(ExecutionMode.CONCURRENT)
public class Test1 extends BaseTest{

    @BeforeAll
    @SneakyThrows
    void setUp(){
        login();
    }


    @Description("Test description")
    @Owner("vsoloviov@gmail.com")
    @Issue("JIRA-001")
    @Test
    void testNegative(){
        List<String> leftMenuItems = openPage(SPORTS_PREMATCH).getNavigationSliderItems();
        assertThat(leftMenuItems.size()).isGreaterThan(0);
        assertThat(leftMenuItems.contains("123")).isTrue();

    }

    @Description("Test description")
    @Owner("vsoloviov@gmail.com")
    @Story("JIRA-002")
    @Test
    void testPosetive(){
        List<String> leftMenuItems = openPage(SPORTS_PREMATCH).getNavigationSliderItems();
        assertThat(leftMenuItems.size()).isGreaterThan(0);
    }
}
