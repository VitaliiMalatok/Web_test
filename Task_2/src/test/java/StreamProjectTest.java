import org.testng.Assert;
import pages.AboutPage;
import pages.CommunityMarketPage;
import pages.MainPage;
import pages.NewReleasesPage;
import setup.BaseTest;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StreamProjectTest {
    public static final int FIRST_ELEMENT = 0;
    public static final int SECOND_ELEMENT = 1;
    public static final int THIRD_ELEMENT = 2;
    final String SEARCH_VALUE = "Golden";
    final int FIRST_TEST = SECOND_ELEMENT;
    final int SECOND_TEST = THIRD_ELEMENT;
    final int THIRD_TEST = 3;
    private MainPage mainPage;
    private AboutPage aboutPage;
    private NewReleasesPage newReleasesPage;
    private CommunityMarketPage communityMarketPage;

    @BeforeClass
    public void initWebDriver() throws IOException {
        BaseTest.initialized();
        aboutPage = new AboutPage();
        mainPage = new MainPage();
        newReleasesPage = new NewReleasesPage();
        communityMarketPage = new CommunityMarketPage();
    }

    @AfterClass
    public void tearDown() {
        BaseTest.quit();
    }

    @Test(priority = FIRST_TEST)
    public void testCaseOne() throws IOException {
        BaseTest.openUrl();
        Assert.assertTrue(mainPage.isMainPageDisplayed(),
                "MainPage is not DISPLAYED(please check internet connection or xPath locators)");
        mainPage.getAboutPage();
        Assert.assertTrue(aboutPage.isAboutPageDisplayed(),
                "AboutPage is not DISPLAYED(please check internet connection or xPath locators)");
        Assert.assertTrue(aboutPage.getNumberOfGamersOnline() > aboutPage.getNumberOfGamersPlaying()
                , "Gamers online is not greater than Gamers in game ");
        aboutPage.getMainPage();
        Assert.assertTrue(mainPage.isMainPageDisplayed(),
                "MainPage is not DISPLAYED(please check internet connection or xPath locators)");
    }

    @Test(priority = SECOND_TEST)
    public void testCaseTwo() throws IOException {
        BaseTest.openUrl();
        Assert.assertTrue(mainPage.isMainPageDisplayed(),
                "MainPage is not DISPLAYED(please check internet connection or xPath locators)");
        mainPage.newTrendLink();
        Assert.assertTrue(newReleasesPage.isNewReleasesPageShown());
        newReleasesPage.getCheckBoxSwitchOs();
        newReleasesPage.getCheckBoxNumberOfPlayers();
        newReleasesPage.getCheckBoxTags();
        Assert.assertTrue(newReleasesPage.getCountOfSearchResult().size() == newReleasesPage.getCountOfGames());
        List<String> paramsOfGame = new ArrayList<>();
        for (String elementOFArrayList : (newReleasesPage.getParamsOfGame())) {
            paramsOfGame.add(elementOFArrayList);
        }
        List<String> paramsOfGameFromGamePage = new ArrayList<>();
        for (String elementOFArrayList : (newReleasesPage.getParamsOfGameFromGamePage())) {
            paramsOfGameFromGamePage.add(elementOFArrayList);
        }
        Assert.assertTrue(paramsOfGame.get(FIRST_ELEMENT).contains(paramsOfGameFromGamePage.get(FIRST_ELEMENT)));
        Assert.assertTrue(paramsOfGame.get(SECOND_ELEMENT).contains(paramsOfGameFromGamePage.get(SECOND_ELEMENT)));
        Assert.assertTrue(paramsOfGame.get(THIRD_ELEMENT).contains(paramsOfGameFromGamePage.get(THIRD_ELEMENT)));

    }

    @Test(priority = THIRD_TEST)
    public void testCaseThree() throws IOException {
        BaseTest.openUrl();
        Assert.assertTrue(mainPage.isMainPageDisplayed(),
                "MainPage is not DISPLAYED(please check internet connection or xPath locators)");
        mainPage.getCommunityMarketPage();
        Assert.assertTrue(communityMarketPage.isCommunityPageDisplayed());
        communityMarketPage.getAdvancedOptionsPopup();
        Assert.assertTrue(communityMarketPage.isPopupMenuIsDisplayed());
        communityMarketPage.getGameParameters();
        Assert.assertTrue(communityMarketPage.isDotaMarkerDisplayed());
        Assert.assertTrue(communityMarketPage.isHeroMarkerDisplayed());
        Assert.assertTrue(communityMarketPage.isImportantMarkerDisplayed());
        Assert.assertTrue(communityMarketPage.isGoldenMarkerDisplayed());
        for (String elementOFArrayList : (communityMarketPage.getSearchResult())) {
            Assert.assertTrue(elementOFArrayList.contains(SEARCH_VALUE));
        }
        communityMarketPage.getDeleteMarker();
    }
}