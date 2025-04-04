import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class shouldFindSelenideRepositoryAtTheTop extends TestBaseExtended {

    @Test
    @DisplayName("Поиск репозитория, открытие его страницы и проверка названия")
    @Feature("")
    @Story("")
    @Owner("Quthonn")
    @Severity(SeverityLevel.TRIVIAL)
    @Link(value = "testing", url = "https://github.com")
    void shouldFindSelenideRepositoryAtTheTop() {


        step("Открытие страницы GitHub", () -> {
            open("https://github.com/");
        });

        step("Нажатие по полю поиска", () -> {
            $(".search-input").click();
        });

        step("Ввод поискового запроса", () -> {
            $("[name=query-builder-test]").setValue("selenide").pressEnter();
        });

        step("Поиск репозитория с названием 'selenide/selenide' и нажатие по нему", () -> {
            $$("a.prc-Link-Link-85e08").findBy(text("selenide/selenide")).click();
        });

        step("Проверка названия репозитория в его странице GitHub", () -> {
            $("#repository-container-header").shouldHave(text("selenide / selenide"));
        });
    }
}