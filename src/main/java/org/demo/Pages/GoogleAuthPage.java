package org.demo.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class GoogleAuthPage {

    SelenideElement login = $("#identifierId");
    SelenideElement pass = $("[name = password]");


    public GoogleAuthPage setLogin(String email){
        login.setValue(email);
        return this;
    }

    public GoogleAuthPage setPassword(String password){
        pass.setValue(password);
        return this;
    }

    public GoogleAuthPage clickOnNext(){
        $$("button").find(Condition.exactText("Далі")).click();
        return this;
    }
}
