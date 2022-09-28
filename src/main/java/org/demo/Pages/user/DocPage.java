package org.demo.Pages.user;

import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class DocPage {

    private ElementsCollection leftMenu = $$("div.left-menu");

    public List<String> getLeftMenuItems(){
        return leftMenu.texts();
    }
}
