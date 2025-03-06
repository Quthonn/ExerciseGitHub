import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import org.openqa.selenium.By;

public class CheckHaveElements {

    @Test
    void solntsevShouldBeTheTopContributor() {
        Configuration.holdBrowserOpen = true;
        open("https://github.com/selenide/selenide");
        $(".BorderGrid").$(byText("Contributors")).ancestor(".BorderGrid-row")
                .$$("ul li").first().hover();
        $$(".Popover .Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));

    }

    @Test
    void CheckHaveCode() {
        Configuration.holdBrowserOpen = true;
        open("https://github.com/selenide/selenide");
        $("[data-content=Wiki]").click();
        $(".markdown-body").shouldHave(text("Soft assertions")).click();
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();

        $(By.cssSelector("html > body > div:nth-of-type(1) > div:nth-of-type(4) > div > main > turbo-frame > div > div > div:nth-of-type(3) > div > div:nth-of-type(1) > div > div:nth-of-type(1) > div:nth-of-type(11) > pre"))
                .shouldBe(visible); // Проверка, что элемент видим на странице
        //последнюю строчку переделать сменив локатор на более читаемый на глаз

    }
}
