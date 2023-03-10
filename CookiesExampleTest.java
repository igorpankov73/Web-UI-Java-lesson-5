package dz_test_lesson_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesExampleTest {
    WebDriver driver;

    @BeforeAll
    static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void runDriver() {
        driver = new ChromeDriver();
    }

    @Test
    void loginToDiaryWithCookieTest() throws InterruptedException {

        driver.get("https://diary.ru");

        Thread.sleep(3000);

        Cookie cookie = new Cookie("Наименование Cookie", "Сюда кладём значение Cookie");
        //P.S. Я не стал регистрироваться на сайте
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        driver.manage().deleteCookie(cookie);

        Thread.sleep(5000);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
