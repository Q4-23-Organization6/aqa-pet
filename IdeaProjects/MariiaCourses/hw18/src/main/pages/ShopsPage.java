package src.main.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopsPage {
    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(20);


    @FindBy(xpath = "//*[@id=\"CITY_SHOP-styler\"]")
    WebElement shopsDropdownList;
    @FindBy(xpath = "//*[contains(text(), 'Всі магазини')]/following-sibling::li[contains(text(), 'Київ')]")
    WebElement kyivCity;
    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[1]/h1")
    WebElement shopsInKyivTitle;

    public ShopsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /* public Select getSelectOptions() {
        return new Select(shopsDropdownList);
    } */

    public void clickOnShopDropdownList() { WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(shopsDropdownList));
        shopsDropdownList.click(); }
    public void clickOnKyivCity() { kyivCity.click(); }

    public String getShopsInKyivTitleText() {
        return shopsInKyivTitle.getText();
    }
    }




