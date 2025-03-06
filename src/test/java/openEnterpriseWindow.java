import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class openEnterpriseWindow {
    @BeforeAll
    public static void BeforeAll() {
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void shouldFindSelenideRepositoryAtTheTop() {
        open("https://github.com/");
        $(By.cssSelector("html > body > div:nth-of-type(1) > div:nth-of-type(3) > header > div > div:nth-of-type(2) > div > nav > ul > li:nth-of-type(2) > button")).click();
        $(By.cssSelector("a[data-analytics-event='{\"location\":\"navbar\",\"action\":\"enterprises\",\"context\":\"solutions\",\"tag\":\"link\",\"label\":\"enterprises_link_solutions_navbar\"}']")).click();
        $(By.cssSelector("a[data-testid='SubNav-root-heading']")).shouldBe(text("Enterprise"));

    }
}