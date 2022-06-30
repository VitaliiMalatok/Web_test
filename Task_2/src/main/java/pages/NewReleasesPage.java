package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import setup.BaseTest;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class NewReleasesPage {
    final String REGEX = "[^0-9]";
    final String PATH = "//div[@class='col search_capsule12']";
    private final By newReleasesPageDisplayed = By.xpath("//form[@id='advsearchform']");
    private final By checkBoxSwitchOs = By.xpath("//span[@data-value='linux']");
    private final By checkBoxNumberOfPlayers = By.xpath("//div[@data-collapse-name='category3']");
    private final By checkBoxLanCoop = By.xpath("//div[@data-collapse-name='category3']//span[@data-value='48']");
    private final By checkBoxTagsAction = By.xpath("//div[@data-loc='Action']");
    private final By searchResult = By.xpath("//div[@class='col search_capsule']");
    private final By countOfGamesLocator = By.xpath("//div[@class='search_results_count']");
    private final By nameOfGameLocator = By.xpath("(//span[@class='title'])[1]");
    private final By nameOfGameFromGamePage = By.xpath("//div[@id='appHubAppName']");
    private final By dateOfReleaseLocator = By.xpath("(//div[@class='col search_released responsive_secondrow'])[1]");
    private final By dateOfReleaseFromGamePage = By.xpath("//div[@class='date']");
    private final By priceOfGameLocator = By.xpath("(//div[@class='col search_price  responsive_secondrow'])[1]");
    private final By priceOfGameFromGamePage = By.xpath("//div[@class='game_purchase_price price']");
    private final By firstGameInSearchLocator = By.xpath("(//div[@id='search_result_container']//a)[1]");

    public boolean isNewReleasesPageShown() {
        return BaseTest.findOfElement(newReleasesPageDisplayed).isDisplayed();
    }

    public void getCheckBoxSwitchOs() {
        BaseTest.findOfElement(checkBoxSwitchOs).click();
    }

    public void getCheckBoxNumberOfPlayers() {
        BaseTest.findOfElement(checkBoxNumberOfPlayers).click();
        BaseTest.findOfElement(checkBoxLanCoop).click();
    }

    public void getCheckBoxTags() {
        BaseTest.findOfElement(checkBoxTagsAction).click();
        try {
            BaseTest.waitOfElement().until(visibilityOfElementLocated(By.xpath(PATH)));
        } catch (Exception e) {
        }
    }

    public List<WebElement> getCountOfSearchResult() {
        List<WebElement> countOfSearchResult = BaseTest.findOfElements(searchResult);
        return countOfSearchResult;
    }

    public int getCountOfGames() {
        int countOfGames = Integer.parseInt(BaseTest
                .findOfElement(countOfGamesLocator)
                .getText().replaceAll(REGEX, ""));
        return countOfGames;
    }

    public List<String> getParamsOfGame() {
        String nameOfGame = BaseTest.findOfElement(nameOfGameLocator).getText();
        String dateOfRelease = BaseTest.findOfElement(dateOfReleaseLocator).getText();
        String priceOfGame = BaseTest.findOfElement(priceOfGameLocator).getText().replaceAll(REGEX, "");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(nameOfGame);
        arrayList.add(dateOfRelease);
        arrayList.add(priceOfGame);
        return arrayList;
    }

    public List<String> getParamsOfGameFromGamePage() {
        BaseTest.findOfElement(firstGameInSearchLocator).click();
        String nameOfGameFromPage = BaseTest.findOfElement(nameOfGameFromGamePage).getText();
        String dateOfReleaseFromPage = BaseTest.findOfElement(dateOfReleaseFromGamePage).getText();
        String priceOfGameFromPage = BaseTest.findOfElement(priceOfGameFromGamePage).getText().replaceAll(REGEX, "");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(nameOfGameFromPage);
        arrayList.add(dateOfReleaseFromPage);
        arrayList.add(priceOfGameFromPage);
        return arrayList;
    }
}




