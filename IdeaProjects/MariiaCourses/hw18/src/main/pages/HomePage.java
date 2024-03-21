package src.main.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    private WebDriver driver;
    @FindBy (xpath = "/html/body/div[2]/main/div[2]/div[3]/div[1]/div[1]/div/div[1]")
    WebElement sectionHeader;
    @FindBy(xpath = "//*[@id=\"title-search-input\"]")
    WebElement searchField;
    @FindBy( id="product_title")
    WebElement code;
    @FindBy ( className="search__btn")
    WebElement searchIcon;
    @FindBy ( xpath="//*[@id=\"header-top\"]/div/div/div[6]/div[2]/div/div[2]/div/div[3]/div[1]")
    WebElement citySelector;
    @FindBy ( xpath = "/html/body/div[2]/div/div[2]/div[1]/h1")
    WebElement shopsListbtn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public  String getSectionHeader() {
        return sectionHeader.getText();
    }
    public void clickOnCitySelector() { citySelector.click(); }
    public void putTextOnSearchField() { searchField.sendKeys("1589283");}
    public void clickOnSearchField() { searchField.click(); }
    public void clickOnSearchIcon() { searchIcon.click(); }
    public String getShopsListButtonText() {
        return shopsListbtn.getText();
    }

}
