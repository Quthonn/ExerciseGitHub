import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class shouldFindSelenideRepositoryAtTheTop {
    @BeforeAll
    public static void BeforeAll() {
        Configuration.holdBrowserOpen = true;

        Configuration.remote = "http://localhost:4445/wd/hub";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "128.0";
        Configuration.browserSize = "1920x1080";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    public void BeforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    public void AfterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }


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