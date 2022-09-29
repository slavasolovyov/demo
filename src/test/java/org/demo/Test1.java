package org.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.demo.Pages.Pages.Entrypoint.DOCUMENTATION;
import static org.demo.Pages.Pages.openPage;
import static org.demo.config.TestConfiguration.SELENOID_URL;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test1 extends BaseTest{

    @BeforeAll
    void setUp(){
        System.out.println("Do precondition");
    }

    @Test
    @Description("some desc")
    @Owner("vsoloviov@gmail.com")
    @Issue("JIRA-001")
    @TmsLink("TMS-001")
    void test(){

        System.out.println("++++++++++++++ " + SELENOID_URL + " +++++++++++++++++");
        List<String> leftMenuItems = openPage(DOCUMENTATION).getLeftMenuItems();
        assertThat(leftMenuItems.size()).isGreaterThan(0);
        Selenide.sleep(10000);
    }
}
