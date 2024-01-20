package ru.aydar.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTableComponent {
    public void checkResultsTableVisible()
    {
        $(".modal-header").shouldBe(visible);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
    }

    public void checkResultsTableHidden()
    {
        $(".modal-header").shouldNotBe(visible);
    }

    public void checkResultsTableValue(String key, String value)
    {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }
}
