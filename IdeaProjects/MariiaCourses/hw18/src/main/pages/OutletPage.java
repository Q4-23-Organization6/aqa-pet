package src.main.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class OutletPage {
    private WebDriver driver;
    @FindBy ( xpath = "/html/body/div[2]/div/div[2]/h1")
    WebElement pageTitle;
   @FindBy (xpath = "/html/body/div[2]/div/div[3]/div[1]/nav/h2")
   WebElement pageSubTitle;
    @FindBy (xpath = "/html/body/div[2]/div/div[3]/div[1]/nav/form/fieldset[1]/div[1]")
    WebElement filterOptionsOne;
    @FindBy (xpath = "//*[@id=\"main-wrapper\"]/div/div[3]/div[1]/div[1]/div[2]/div/div[1]")
    WebElement sorting;
    @FindBy (xpath = "//*[@id=\"main-wrapper\"]/div/div[3]/div[1]/div[1]/div[2]/div/div[2]/button[2]")
    WebElement sortAscending;
    @FindBy (xpath = "//*[@id=\"main-wrapper\"]/div/div[3]/div[1]/div[1]/div[2]/div/div[1]")
    WebElement rightSorting;
    public OutletPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    Duration timeoutone = Duration.ofSeconds(60);
    Duration timeouttwo = Duration.ofSeconds(15);
    public String getPageTitle() {
        return pageTitle.getText();
    }
    public String getPageSubTitle() {
        return pageSubTitle.getText();
    }
    public String getFilterOptionsOne() {
        return filterOptionsOne.getText();
    }
    public void clickOnSorting() {
        sorting.click();
    }
    public void sortAscending() {
        WebDriverWait wait = new WebDriverWait(driver, timeouttwo);
        WebElement firstCheckboxElement = wait.until(ExpectedConditions.elementToBeClickable(sortAscending));
        sortAscending.click();

    }
    public String getRightSorting() {
        long waitTime = TimeUnit.SECONDS.toNanos(10);
        long startTime = System.nanoTime();
        long endTime = startTime + waitTime;

        while (System.nanoTime() < endTime) {
            LockSupport.parkNanos(endTime - System.nanoTime());
        }
        return rightSorting.getText();
    }
}
