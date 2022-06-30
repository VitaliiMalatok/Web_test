package pages;

import org.openqa.selenium.By;
import setup.BaseTest;
import java.util.ArrayList;
import java.util.List;

public class CommunityMarketPage {
    final String INPUT_VALUE = "golden";
    final int COUNT_OF_CHECK_ELEMENTS = 5;
    private final By commyunityPageLocator = By.xpath("//div[@id='BG_top']");
    private final By advancedOptionsLocator = By.xpath("//div[@class='market_search_advanced_button']");
    private final By popupLocator = By.xpath("//div[@class='newmodal' and @data-panel]");
    private final By selectDotaLocator = By.xpath("//div[@id='app_option_570']");
    private final By activitySwitchGameMenu = By.xpath("//div[@id='market_advancedsearch_appselect']");
    private final By activitySwitchHeroMenu = By.xpath("//select[@name='category_570_Hero[]']");
    private final By selectHeroLocator = By.xpath("//option[@value='tag_npc_dota_hero_life_stealer']");
    private final By checkBoxImportant = By.xpath("//input[@id='tag_570_Rarity_Rarity_Immortal']");
    private final By searchMenu = By.xpath("//input[@id='advancedSearchBox']");
    private final By submitButton = By.xpath("//div[contains(@onclick,'submit')]");
    private final By dotaMarker = By.xpath("//div[@class='market_search_results_header']//a[1]");
    private final By deleteSearchParameters = By.xpath("//div[@class='market_search_results_header']//a[5]");
    private final By heroMarker = By.xpath("//div[@class='market_search_results_header']//a[2]");
    private final By importantMarker = By.xpath("//div[@class='market_search_results_header']//a[3]");
    private final By goldenMarker = By.xpath("//div[@class='market_search_results_header']//a[4]");
    private final By gameNameMarker = By.xpath("//span[@class='market_listing_item_name']");

    public boolean isCommunityPageDisplayed() {
        return BaseTest.findOfElement(commyunityPageLocator).isDisplayed();
    }

    public void getAdvancedOptionsPopup(){
        BaseTest.findOfElement(advancedOptionsLocator).click();
    }

    public boolean isPopupMenuIsDisplayed(){
        return BaseTest.findOfElement(popupLocator).isDisplayed();
    }

    public void getGameParameters(){
        BaseTest.findOfElement(activitySwitchGameMenu).click();
        BaseTest.findOfElement(selectDotaLocator).click();
        BaseTest.findOfElement(activitySwitchHeroMenu).click();
        BaseTest.findOfElement(selectHeroLocator).click();
        BaseTest.findOfElement(checkBoxImportant).click();
        BaseTest.findOfElement(searchMenu).sendKeys(INPUT_VALUE);
        BaseTest.findOfElement(submitButton).click();
    }

    public boolean isDotaMarkerDisplayed(){
        return  BaseTest.findOfElement(dotaMarker).isDisplayed();
    }

    public boolean isHeroMarkerDisplayed(){
        return  BaseTest.findOfElement(heroMarker).isDisplayed();
    }

    public boolean isImportantMarkerDisplayed(){
        return  BaseTest.findOfElement(importantMarker).isDisplayed();
    }

    public boolean isGoldenMarkerDisplayed(){
        return  BaseTest.findOfElement(goldenMarker).isDisplayed();
    }

    public List<String> getSearchResult(){
        List<String> arrayList = new ArrayList<>();
        for (int i = 0; i < COUNT_OF_CHECK_ELEMENTS; i++) {
            arrayList.add(BaseTest.findOfElements(gameNameMarker).get(i).getText());
        }
        return  arrayList;
    }

    public void getDeleteMarker(){
        BaseTest.findOfElement(deleteSearchParameters).click();
    }
}

