package pages;

import org.openqa.selenium.By;
import setup.BaseTest;

public class AboutPage {
    final String REGEX = "[^0-9]";
    private final By mainPageLink = By.xpath("//div[@id='global_header']//a");
    private final By successAboutPageLocator = By.xpath("//div[@id='about_greeting']");
    private final By numberOfGamersOnline = By.xpath("//div[contains(@class,'gamers_online')]//ancestor::div[@class='online_stat']");
    private final By numberOfGamersPlaying = By.xpath("//div[contains(@class,'gamers_in_game')]//ancestor::div[@class='online_stat']");

    public boolean isAboutPageDisplayed() {
        return BaseTest.findOfElement(successAboutPageLocator).isDisplayed();
    }

    public int getNumberOfGamersOnline() {
        int online = Integer.parseInt(BaseTest
                .findOfElement(numberOfGamersOnline)
                .getText().replaceAll(REGEX, ""));
        return online;
    }

    public int getNumberOfGamersPlaying() {
        int playing = Integer.parseInt(BaseTest
                .findOfElement(numberOfGamersPlaying)
                .getText().replaceAll(REGEX, ""));
        return playing;
    }

    public void getMainPage() {
        BaseTest.findOfElement(mainPageLink).click();
    }
}
