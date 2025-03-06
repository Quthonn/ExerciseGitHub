import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class shouldFindSelenideRepositoryAtTheTop {
    @BeforeAll
    public static void BeforeAll() {
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        open("https://github.com/");
        $(".search-input").click();
        $("[name=query-builder-test]").setValue("selenide").pressEnter();
        sleep(1000);
        $$("a.prc-Link-Link-85e08").findBy(text("selenide/selenide")).click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));

    }
}