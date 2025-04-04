import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class openEnterpriseWindow extends TestBaseExtended {

    @Test
    @DisplayName("Открытие раздела Enterprises и проверка его названия")
    @Feature("")
    @Story("")
    @Owner("Quthonn")
    @Severity(SeverityLevel.TRIVIAL)
    @Link(value = "testing", url = "https://github.com")
    void shouldFindSelenideRepositoryAtTheTop() {
        step("Открытие страницы GitHub", () -> {
            open("https://github.com/");
        });

        step("Открытие раздела Solutions", () -> {
            $(By.cssSelector("html > body > div:nth-of-type(1) > " +
                    "div:nth-of-type(3) > header > div > div:nth-of-type(2) > " +
                    "div > nav > ul > li:nth-of-type(2) > button")).click();
        });

        step("Нажатие по кнопке Enterprises", () -> {
            $(By.cssSelector("a[data-analytics-event='{\"location\":\"navbar\"," +
                    "\"action\":\"enterprises\",\"context\":\"solutions\"," +
                    "\"tag\":\"link\",\"label\":" +
                    "\"enterprises_link_solutions_navbar\"}']")).click();
        });

        step("Проверка названия страницы", () -> {
            $(By.cssSelector("a[data-testid='SubNav-root-heading']")).shouldBe(text("Enterprise"));
        });
    }
}