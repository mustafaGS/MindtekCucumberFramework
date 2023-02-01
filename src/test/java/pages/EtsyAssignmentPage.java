package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class EtsyAssignmentPage {

    public EtsyAssignmentPage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "global-enhancements-search-query")
    public WebElement searchCBox;

    @FindBy(xpath = "//span[@class='wt-hide-xs wt-show-md filter-expander']")
    public WebElement filterCButton;

    @FindBy(id = "price-input-custom")
    public WebElement chairCustomBtn;

    @FindBy(id = "search-filter-min-price-input")
    public WebElement lowBox;

    @FindBy (id = "search-filter-max-price-input")
    public WebElement highBox;

    @FindBy(xpath = "//button[contains(text(),'Apply')]")
    public WebElement applyCButton;

    @FindBy(xpath = "//div[@class='wt-bg-white wt-display-block wt-pb-xs-2 wt-mt-xs-0']//span[@class='currency-value']")
    public List<WebElement> listOfChairItemsPrices;

    @FindBy(xpath = "//div[@class='wt-bg-white wt-display-block wt-pb-xs-2 wt-mt-xs-0']//span[@class='currency-value']")
    public List<WebElement> listOfCarpetItemsPrices;

    @FindBy(xpath = "//div[@class='wt-bg-white wt-display-block wt-pb-xs-2 wt-mt-xs-0']//span[@class='currency-value']")
    public List<WebElement> listOfTableItemsPrices;




}
