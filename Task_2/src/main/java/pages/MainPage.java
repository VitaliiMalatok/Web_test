package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.BaseTest;

public class MainPage {
    final String NEW_RELEASES_PAGE_LINK = "//a[@class='popup_menu_item' and contains(@href,'topsellers')]";
    private final By mainPageLocator = By.xpath("//div[@id='module_special_offers']");
    private final By aboutPageLocator = By.xpath("//div[@id='global_header']//a[contains(@href,'about') and @class='menuitem']");
    private final By popupMenuLocator = By.xpath("//div[@id='noteworthy_tab']");
    private final By communityMenuLocator = By.xpath("//div[@class='supernav_container']//a[@data-tooltip-content='.submenu_community']");
    private final By marketMenuLocator = By.xpath("//div[@class='supernav_content']//a[contains(@href,'/market')]");

    public boolean isMainPageDisplayed() {
        return BaseTest.findOfElement(mainPageLocator).isDisplayed();
    }

    public void getAboutPage() {
        BaseTest.findOfElement(aboutPageLocator).click();
    }

    public void newTrendLink() {
        BaseTest.actionOfElement().moveToElement(BaseTest.findOfElement(popupMenuLocator)).build().perform();
        BaseTest.waitOfElement().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NEW_RELEASES_PAGE_LINK))).click();
    }

    public void getCommunityMarketPage() {
        BaseTest.actionOfElement().moveToElement(BaseTest.findOfElement(communityMenuLocator)).build().perform();
        BaseTest.findOfElement(marketMenuLocator).click();

    }
}
