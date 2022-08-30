package mytest;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class GithubTests {

    @BeforeAll
    static void beforeAllTests(){
        Selenide.clearBrowserCookies();
    }

    @Test
    void pricingTest(){
        open("https://github.com/");

        $(withText("Pricing")).hover();
        $(byText("Compare plans")).click();
        $("#compare-features").$$("h2").shouldHave(texts("Free","Team","Enterprise"));
    }
}
