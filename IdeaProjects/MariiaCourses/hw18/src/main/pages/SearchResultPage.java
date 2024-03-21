package src.main.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
    private WebDriver driver;
    @FindBy( xpath = "/html/body/div[2]/div/div[2]/div[1]/div[2]/article[1]/div[3]/a/h2")
    WebElement articlecard;
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getArticleCardText() { return articlecard.getText();}
}
