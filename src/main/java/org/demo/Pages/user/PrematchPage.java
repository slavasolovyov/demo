package org.demo.Pages.user;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class PrematchPage {

    private SelenideElement navigatationElement = $x("//ul[contains(@class, 'PillsNavigation_list')]");

    @Step("Get navigation slider items")
    public List<String> getNavigationSliderItems(){
        ElementsCollection sliderElements = navigatationElement.shouldBe(visible).$$x(".//li");
        return sliderElements.texts();
    }
}
