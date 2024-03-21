package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import src.main.pages.HomePage;
import src.main.pages.OutletPage;
import src.main.pages.SearchResultPage;
import src.main.pages.ShopsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageObjectTest {
    private WebDriver driver;
    private HomePage homePage;
    private OutletPage outletPage;
    private SearchResultPage searchResultPage;
    private ShopsPage shopsPage;

    @BeforeEach
    public void initBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = PageFactory.initElements(driver, HomePage.class);
        outletPage = PageFactory.initElements(driver, OutletPage.class);
        searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
        shopsPage = PageFactory.initElements(driver, ShopsPage.class);
        driver.get("https://aurum.in.ua/ua/");


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
   @AfterEach
   void quitBrowser() {
        driver.close();
    }

    @Test
    public void verifySectionHeaderTest() {
    String actualSectionHeader = homePage.getSectionHeader();
    assertEquals(actualSectionHeader,"Популярні товари категорій", "Section title valid");
    }

    @Test
    public void verifyArticleSearch() {
        driver.switchTo().activeElement();
        homePage.clickOnCitySelector();
        homePage.clickOnSearchField();
        homePage.putTextOnSearchField();
        homePage.clickOnSearchIcon();
        String actualSearchResult = searchResultPage.getArticleCardText();
        assertEquals(actualSearchResult,"Золота каблучка для заручин з діамантом - 1589283", "Correct Article");
    }

    @Test
    public void verifyShopsPage() {
        driver.get("https://aurum.in.ua/ua/shops/");
        String Shopsbtn = homePage.getShopsListButtonText();
        assertEquals(Shopsbtn, "Всі магазини", "Shops page title valid");
    }
    @Test
    public void verifyCityShops() {
        driver.get("https://aurum.in.ua/ua/shops/");
        shopsPage.clickOnShopDropdownList();
        shopsPage.clickOnKyivCity();
        String ShopsInKyivTitle = shopsPage.getShopsInKyivTitleText();
        assertEquals(ShopsInKyivTitle, "Ювелірні магазини в місті Київ", "Correct text");

    }
    @Test
    public void verifyOutletTitleTest() {
        driver.get("https://aurum.in.ua/ua/c/outlet/");
        String actualPageTitle = outletPage.getPageTitle();
        assertEquals(actualPageTitle,"Outlet", "Section title valid");
    }
    @Test
    public void verifySortingOutletPage() {
        driver.get("https://aurum.in.ua/ua/kiev/c/outlet/");
        outletPage.clickOnSorting();
        outletPage.sortAscending();
        String rightSorting = outletPage.getRightSorting();
        assertEquals(rightSorting,"Ціна за зростанням", "correct title");
    }

    @Test
    public void verifyFilterOptionOne() {
        driver.get("https://aurum.in.ua/ua/c/outlet/");
        String actualPageTitle = outletPage.getFilterOptionsOne();
        assertEquals(actualPageTitle,"Наявність в магазинах", "Section title valid");
    }

}
