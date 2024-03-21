package pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "username")
    WebElement userName;

    @FindBy(id = "password")
    WebElement userPass;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/button/i\n")
    WebElement loginButton;

    @FindBy(id = "flash")
    WebElement confirmMsg;

    public void inputName(String name) {
        waiter(userName);
        userName.sendKeys(name);
    }

    public void inputPass(String pass) {
        waiter(userPass);
        userPass.sendKeys(pass);
    }

    public void clickloginButton() {
        waiter(loginButton);
        loginButton.click();
    }

    public String getMsg() {
        waiter(confirmMsg);
        confirmMsg.isDisplayed();
        return confirmMsg.getText();
    }

    private void waiter(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.pollingEvery(Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
