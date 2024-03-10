package pack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTests {
    ChromeDriver driver;
    LoginPage loginPage;

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    void closeDriver() {
        driver.close();
    }

    @Test
    public void successLoginTest() {
        loginPage.inputName("tomsmith");
        loginPage.inputPass("SuperSecretPassword!");
        loginPage.clickloginButton();
        Assertions.assertEquals("You logged into a secure area!\n" +
                "×", loginPage.getMsg());
    }

    @Test
    public void failLoginTest() {
        loginPage.inputName("tom");
        loginPage.inputPass("SuperSecretPassword!");
        loginPage.clickloginButton();
        Assertions.assertEquals("Your username is invalid!\n" +
                "×", loginPage.getMsg());
    }
}
