import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

import org.openqa.selenium.By;

public class CheckHaveElements {

    @BeforeAll
    public static void BeforeAll() {
        Configuration.holdBrowserOpen = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    @DisplayName("Проверка имени первого участника репозитория")
    @Feature("")
    @Story("")
    @Owner("Quthonn")
    @Severity(SeverityLevel.TRIVIAL)
    @Link(value = "testing", url = "https://github.com")
    void solntsevShouldBeTheTopContributor() {
        step("Открытие страницы GitHub", () -> {
            open("https://github.com/selenide/selenide");
        });

        step("Пролистать до значка 1-го участника репозитория и навести на него курсор", () -> {
            $(".BorderGrid").$(byText("Contributors")).ancestor(".BorderGrid-row")
                    .$$("ul li").first().hover();
        });

        step("Проверить его имя", () -> {
            $$(".Popover .Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
        });
    }

    @Test
    @DisplayName("Проверка наличия исходного кода в разделе Soft Assertions")
    @Feature("")
    @Story("")
    @Owner("Quthonn")
    @Severity(SeverityLevel.TRIVIAL)
    @Link(value = "testing", url = "https://github.com")
    void CheckHaveCode() {
        Configuration.holdBrowserOpen = true;
        step("Открытие страницы GitHub", () -> {
            open("https://github.com/selenide/selenide");
        });

        step("Переход в раздел Wiki", () -> {
            $("[data-content=Wiki]").click();
        });

        step("Проверка наличия раздела Soft Asserrtions", () -> {
            $(".markdown-body").shouldHave(text("Soft assertions")).click();
        });

        step("Переход в раздел Soft Asserrtions", () -> {
            $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();
        });

        step("Проверка наличия исходного кода", () -> {
            $(By.cssSelector("html > body > div:nth-of-type(1) > div:nth-of-type(4) > div > main > turbo-frame > div > div > div:nth-of-type(3) > div > div:nth-of-type(1) > div > div:nth-of-type(1) > div:nth-of-type(11) > pre"))
                    .shouldBe(visible); // Проверка, что элемент видим на странице
            //последнюю строчку переделать сменив локатор на более читаемый на глаз
        });
    }
}
